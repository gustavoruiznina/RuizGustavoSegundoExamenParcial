package com.emergentes.dao;

import com.emergentes.modelo.Libros;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAOimpl extends ConexionDB implements LibrosDAO {

    @Override
    public void insert(Libros libros) throws Exception {
        String sql = "insert into libros (titulo,autor,disponible,categoria) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, libros.getTitulo());
        ps.setString(2, libros.getAutor());
        ps.setString(3, libros.getDisponible());
        ps.setString(4, libros.getCategoria());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Libros libros) throws Exception {
        String sql = "update libros set titulo=?,autor=?,disponible=?,categoria=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, libros.getTitulo());
        ps.setString(2, libros.getAutor());
        ps.setString(3, libros.getDisponible());
        ps.setString(4, libros.getCategoria());
        ps.setInt(5, libros.getId());
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from libros where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public Libros getById(int id) throws Exception {
        Libros lib = new Libros();
        try {
            String sql = "select * from libros WHERE id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lib.setId(rs.getInt("id"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setDisponible(rs.getString("disponible"));
                lib.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lib;
    }

    @Override
    public List<Libros> getAll() throws Exception {
        List<Libros> lista = null;
        String sql = "select * from libros";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Libros>();
        while (rs.next()) {
            Libros lib = new Libros();
            lib.setId(rs.getInt("id"));
            lib.setTitulo(rs.getString("titulo"));
            lib.setAutor(rs.getString("autor"));
            lib.setDisponible(rs.getString("disponible"));
            lib.setCategoria(rs.getString("categoria"));
            lista.add(lib);
        }
        this.desconectar();
        return lista;
    }

}
