/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.SQLCommands;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rowan_user
 */
public class FAA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        
                SQLCommands sqc = new SQLCommands();
              
		String url = "jdbc:oracle:thin:@//localhost:1521/cablocal";
		Connection con = DriverManager.getConnection(url, "uret01", "rowan");
		sqc.viewTable(con, "cablocal");
    }
    
}
