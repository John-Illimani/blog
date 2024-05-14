/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controller;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.model.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author illim
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BlogDAO dao = new BlogDAOimpl();
            int id;
            Blog avi = new Blog();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("blog", avi);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    request.setAttribute("blog", avi); // Agregar el aviso al atributo de la solicitud
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/MainServlet");
                    break;
                case "view":
                    List<Blog> lista = dao.getAll();

                    request.setAttribute("blogs", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        Blog avi = new Blog();

        avi.setId(id);
        avi.setFecha(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);

        if (id == 0) {
            try {
                BlogDAO dao = new BlogDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }

        } else {
            try {
                BlogDAO dao = new BlogDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath() + "/MainServlet");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }


}
