/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import java.util.List;

/**
 *
 * @author CORE I5
 */
public interface CategoriasDAO {
    public void insert(Categorias categorias) throws Exception;
    public void update(Categorias categorias) throws Exception;
    public void delete(int id) throws Exception;
    public Categorias getById(int id) throws Exception;
    public List<Categorias> getAll() throws Exception;
}
