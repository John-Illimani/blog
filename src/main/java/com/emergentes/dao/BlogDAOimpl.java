/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.model.Blog;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author illim
 */
public class BlogDAOimpl extends ConexionDB implements BlogDAO {

 @Override
    public void insert(Blog aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into posts(fecha,titulo,contenido) value(?,?,?)");
            ps.setString(1, aviso.getFecha());
            ps.setString(2, aviso.getTitulo());
            ps.setString(3, aviso.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Blog aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update posts set fecha = ?,titulo = ?, contenido = ? where id = ?");
            ps.setString(1, aviso.getFecha());
            ps.setString(2, aviso.getTitulo());
            ps.setString(3, aviso.getContenido());
            ps.setInt(4, aviso.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from posts where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog avi = new Blog();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from posts  where id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista = null;

        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from posts order by fecha desc");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Blog>();
            while (rs.next()) {
                Blog avi = new Blog();
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
                lista.add(avi);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return lista;

    }

    
}
