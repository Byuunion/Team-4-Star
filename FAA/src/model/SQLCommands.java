package model;

import java.sql.*;
import java.util.ArrayList;

public class SQLCommands {
	
	private ArrayList<InstanceACList> List_Of_Data;
	private static Connection conn;

	public SQLCommands(String url, String user, String ext) throws SQLException {
		List_Of_Data = new ArrayList<InstanceACList>();
		conn = DriverManager.getConnection(url, user, ext);
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void clear() {
		List_Of_Data = new ArrayList<InstanceACList>();
	}
	
	public boolean isClear() {
		if(List_Of_Data == null || List_Of_Data.size() < 1) {
			return true;
		}
		return false;
	}

	public static void viewTable(String dbName) throws SQLException {
		    Statement stmt = null;
		    String query = "select ACID " +
		                   "from " + dbName + ".AC_LISTRW15150804";
		    try {
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String acid = rs.getString("ACID");
		            System.out.println(acid);
		        }
		    } catch (SQLException e ) {
		        System.err.println(e.toString());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
	
	public static void viewTable(String dbName, String colName) throws SQLException {
	    Statement stmt = null;
	    String query = "select " + colName +
	                   " from " + dbName + ".AC_LISTRW15150804";
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String acid = rs.getString(colName);
	            System.out.println(acid);
	        }
	    } catch (SQLException e ) {
	        System.err.println(e.toString());
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	public static void viewTable(String dbName, String colName, String tableName) throws SQLException {
	    Statement stmt = null;
	    String query = "select " + colName +
	                   " from " + dbName + "."+ tableName;
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String acid = rs.getString(colName);
	            System.out.println(acid);
	        }
	    } catch (SQLException e ) {
	        System.err.println(e.toString());
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}
