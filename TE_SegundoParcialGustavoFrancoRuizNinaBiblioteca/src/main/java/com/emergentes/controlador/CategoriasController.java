/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.CategoriasDAO;
import com.emergentes.dao.CategoriasDAOimpl;
import com.emergentes.modelo.Categorias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CORE I5
 */
@WebServlet(name = "CategoriasController", urlPatterns = {"/CategoriasController"})
public class CategoriasController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriasDAO dao = new CategoriasDAOimpl();
        Categorias cat = new Categorias();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("categorias", cat);
                request.getRequestDispatcher("frmcategorias.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    cat = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro" + ex.getMessage());
                }
                request.setAttribute("categorias", cat);
                request.getRequestDispatcher("frmcategorias.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar" + ex.getMessage());
                }
                response.sendRedirect("CategoriasController");
                break;
            case "view":
                List<Categorias> lista = new ArrayList<Categorias>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar" + ex.getMessage());
                }
                request.setAttribute("categorias", lista);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
            default:
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String categoria = request.getParameter("categoria");
        Categorias cat = new Categorias();

        cat.setId(id);
        cat.setCategoria(categoria);

        CategoriasDAO dao = new CategoriasDAOimpl();

        if (id == 0) {
            try {
                dao.insert(cat);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                dao.update(cat);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }

        }
        response.sendRedirect("CategoriasController");
    }
}


