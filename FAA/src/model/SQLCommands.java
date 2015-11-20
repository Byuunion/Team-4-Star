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
import java.sql.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class SQLCommands {
	
        private String returnedString;
	//private ArrayList<InstanceOfData> List_Of_Data;
	
        public String getReturnedString(){
            return returnedString;
        }
        
	public void SQLCommands() {
		//List_Of_Data = new ArrayList<InstanceOfData>();
	}
	
	public void clear() {
		//List_Of_Data = new ArrayList<InstanceOfData>();
	}
	
	public boolean isClear() {
		//if(List_Of_Data == null || List_Of_Data.size() < 1) {
			//return true;
		//}
		return false;
	}

	public static void viewTable(Connection con, String dbName) throws SQLException {
		    Statement stmt = null;
                    StringBuilder sb = new StringBuilder();
                    // SELECT COUNT(*) FROM AC_LISTRW15150804 WHERE AC_NUM LIKE '%59%'
		    String query = "SELECT AC_NUM, ACID FROM AC_LISTRW15150804";
                    String query2 = "Select ";
		    try {
		        stmt = con.createStatement();
		        ResultSet listSet = stmt.executeQuery(query);
                        ResultSet trackSet = stmt.executeQuery(query2);
                        sb.append("acNum, acID\n");
		        while (listSet.next()) {
                            String acNum = listSet.getString("AC_NUM");
		            String acID = listSet.getString("ACID");
		            sb.append(acNum + ", " + acID + "\n");
		        }
		    } catch (SQLException e ) {
		        System.err.println(e.toString());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
	
	public static void viewTable(Connection con, String dbName, String colName) throws SQLException {
	    Statement stmt = null;
	    String query = "select " + colName +
	                   " from " + dbName + ".AC_LIST";
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String acid = rs.getString("colName");
	            System.out.println(acid);
	        }
	    } catch (SQLException e ) {
	        System.err.println(e.toString());
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}