package com.crud.dao;

import java.sql.*;
import java.util.*;
import com.crud.modelo.Usuario;

public class UsuarioDAO {
    String jdbcURL = "jdbc:mysql://localhost:3306/crud_web";
    String jdbcUser = "root";
    String jdbcPass = "";

    Connection con;

    public UsuarioDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertar(Usuario u) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (nombre, email, telefono) VALUES (?, ?, ?)");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Usuario u) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET nombre=?, email=?, telefono=? WHERE id=?");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getTelefono());
            ps.setInt(4, u.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario obtenerPorId(int id) {
        Usuario u = new Usuario();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
