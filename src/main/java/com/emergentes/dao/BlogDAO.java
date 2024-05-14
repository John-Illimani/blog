/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.model.Blog;
import java.util.List;

/**
 *
 * @author illim
 */
public interface BlogDAO {
    public void insert (Blog aviso) throws Exception;
    public void update (Blog aviso) throws Exception;
    public void delete (int id) throws Exception;
    public Blog getById (int id) throws Exception;
    public List<Blog> getAll () throws Exception;
    
    
}
