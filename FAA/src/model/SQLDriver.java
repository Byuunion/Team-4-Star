package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rowan_user
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.sql.*;

public class SQLDriver {

	public void main(String args[]) throws SQLException, IOException {

                
                File file = new File("/home/rowan_user/custom.txt");
                
                if(!file.exists()){
                    file.createNewFile();

                
                }
                FileWriter fileWriter = new FileWriter(file);
                
                fileWriter.write("test");
                
                
            

		SQLCommands sqc = new SQLCommands();
		System.out.println("test");
		String url = "jdbc:sqlplus:cablocal";
		Connection con = DriverManager.getConnection(url, "uret01", "rowan");
		sqc.viewTable(con, "pariphae_cablocal");
                
	}
}