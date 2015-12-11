package mkOne.Model;

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
import java.util.Scanner;

public class SQLDriver {

	public static void main(String args[]) throws SQLException, IOException {
                Scanner sc = new Scanner(System.in);
                
                System.out.print("Enter a scenario: ");
                String scenario = sc.nextLine();
                
                File file = new File("/home/rowan_user/" + scenario + ".csv");
                
                if(!file.exists()){
                    file.createNewFile();
                    System.out.println("File Created");
                }
                
                FileWriter writer = new FileWriter(file);
                
                
            

		SQLCommands sqc = new SQLCommands();
		
                
		String url = "jdbc:oracle:thin:@//localhost:1521/cablocal";
		Connection conn = DriverManager.getConnection(url, "uret01", "rowan");
		
		sqc.setScenario(scenario);
		sqc.setConnection(conn);
		sqc.queryTable();
                
                writer.write(sqc.getReturnedString());
                writer.flush();
                writer.close();
	}
}