package com.pau.cse.model.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.pau.cse.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.pau.cse.model.bean.Temperatura;

/**
 *
 * @author Samuelson
 */
public class TemperaturaDAO {

    public boolean save (Temperatura t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO temperature (valuetemp) VALUES (?)");
            stmt.setDouble(1, t.getValor());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.err.println("Erro ao salvar: "+ex);
            return false;
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
       }
    
  
    public static void main(String args[])  //static method  
    {  
    	Temperatura temp = new Temperatura();
    	temp.setValor(23.0);
    	
    	TemperaturaDAO dao = new TemperaturaDAO();
    	if(dao.save(temp)) {
    		System.out.println("Success");
    		
    	}else {
    		System.out.println("Error");
    	}
    }  
    
    
    
    

}