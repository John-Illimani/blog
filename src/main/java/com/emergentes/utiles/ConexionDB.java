/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author illim
 */
public class ConexionDB {
    String driver = "com.mysql.jdbc.Driver";
     static public   String url = "jdbc:mysql://localhost:3306/bd_blog";
     static public   String usuario = "root";
     static public   String password = "Promocion2012";
    
    protected Connection conn=null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,password);
            if(conn!=null){
                System.out.println("Conexion OK "+conn);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ex.getMessage());
        }
        
    }
    
    public Connection conectar(){
    return conn;
    }
    public void desconectar(){
        System.out.println("Cerrando la BD "+conn);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
