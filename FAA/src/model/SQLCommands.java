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
import java.util.Set;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.lang.Math;

public class SQLCommands {

	private static String returnedString;
	private static Connection conn;
	// private ArrayList<InstanceOfData> List_Of_Data;
	private static String scenario;
        
    private static HashSet<Integer> mostCommonZs;
    
    public SQLCommands() {
    	mostCommonZs = new HashSet<Integer>();
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void setConnection(Connection conn) {
		SQLCommands.conn = conn;
	}

	public void setScenario(String sc) {
		scenario = sc;
	}

	public String getScenario() {
		return scenario;
	}

	public String getReturnedString() {
		return returnedString;
	}
        
        public static void setReturnedString(String str) {
		returnedString = str;
	}

	

	public void clear() {
		// List_Of_Data = new ArrayList<InstanceOfData>();
	}

	public boolean isClear() {
		// if(List_Of_Data == null || List_Of_Data.size() < 1) {
		// return true;
		// }
		return false;
	}

	public static void queryTable() throws SQLException {
		Statement stmt, stmt2 = null;
        int Max_Z, Min_Z;
        int minTime, maxTime, elapseTime, minGSpeed, maxGSpeed, avgClimbSpeed;
        boolean minNotFound, maxNotFound;
		StringBuilder sb = new StringBuilder();
		// SELECT COUNT(*) FROM AC_TRKSRW15150804 WHERE Z_Value = 32000 AND AC_NUM = 50;
		// AC_TRKSRW15150804 AC_LISTRW15150804
		// select ground_speed_smo, z_value from ac_trksrw15150804 where ac_num = 62;
                // select elap_time, ground_speed_smo, z_value from ac_trksrw15150804 where ac_num = 62 AND rownum < 10;
		String query = "SELECT * FROM AC_LISTRW" + scenario;
		try {
			stmt = conn.createStatement();
            stmt2 = conn.createStatement();
			ResultSet listSet = stmt.executeQuery(query);
                        sb.append("AC_NUM, " + 
                                    "ACID, " + 
                                    "TRACK_CNT, " + 
                                    "ST_TIME, " + 
                                    "END_TIME, " + 
                                    "ORIG_ST_TIME, " + 
                                    "END_ST_TIME, " + 
                                    "MAX_X, " + 
                                    "MIN_X, " + 
                                    "MAX_Y, " + 
                                    "MIN_Y, " + 
                                    "MAX_Z, " + 
                                    "MIN_Z, " + 
                                    "AC_EQUIP, " + 
                                    "AC_TYPE, " + 
                                    "DEST_FIX, " + 
                                    "FLIGHT_TYPE, " + 
                                    "ORIGIN_FIX, " + 
                                    "GAP_VALUE, " + 
                                    "MAX_X_SMO, " + 
                                    "MIN_X_SMO, " + 
                                    "MAX_Y_SMO, " + 
                                    "MIN_Y_SMO, " + 
                                    "MAX_Z_SMO, " + 
                                    "MIN_Z_SMO, " + 
                                    "TOD_TIME, " + 
                                    "TOC_TIME, " + 
                                    "TOC_ALT, " + 
                                    "END_CENTER, " + 
                                    "START_CENTER, " + 
                                    "END_CENTER_TIME, " + 
                                    "START_CENTER_TIME, " + 
                                    "LOW_Z" + ", " + 
                                    "HIGH_Z" + ", " + 
                                    "LOW_TIME" + ", " + 
                                    "HIGH_TIME" + ", " + 
                                    "BETWEEN_TIME" + ", " + 
                                    "AVG_CLIMB" + ", " + 
                                    "LOW_GROUND_SPEED_SMO" + ", " + 
                                    "HIGH_GROUND_SPEED_SMO" + "\n");
                        
			while (listSet.next()) {
				String acNum = listSet.getString("AC_NUM");
				String query2 = "SELECT ELAP_TIME, Z_VALUE, GROUND_SPEED_SMO FROM AC_TRKSRW" + scenario +
                                        " where AC_NUM = " + acNum;
				ResultSet Track_Nums = stmt2.executeQuery(query2);
                                
				Max_Z = 0;
				Min_Z = 0;
                minNotFound = true;
                maxNotFound = true;
                minTime = 0;
                maxTime = 0;
                elapseTime = 0;
                minGSpeed = 0;
                maxGSpeed = 0;
                                
				while(Track_Nums.next()) {
                                    
                    // Take the first value as min
                    // compare it with max Z
					if(minNotFound) {
						Min_Z = Track_Nums.getInt("Z_VALUE");
	                    minTime = Track_Nums.getInt("ELAP_TIME"); 
	                    minGSpeed = Track_Nums.getInt("GROUND_SPEED_SMO");
	                    minNotFound = false;
					}
					
                    if(Track_Nums.getInt("Z_VALUE") <= Max_Z && maxNotFound == true){
                		maxNotFound = false;
                    }
                    
                    if(Track_Nums.getInt("Z_VALUE") > Max_Z && maxNotFound == true){
                        Max_Z = Track_Nums.getInt("Z_VALUE");
                        maxTime = Track_Nums.getInt("ELAP_TIME");
                        maxGSpeed = Track_Nums.getInt("GROUND_SPEED_SMO");
                    }                               
				}
                                
                    elapseTime = maxTime - minTime;
                    avgClimbSpeed = Math.abs((maxGSpeed - minGSpeed)/elapseTime);
                                
                    if(Min_Z + 3000 < Max_Z){
                        sb.append(listSet.getString("AC_NUM")).append(", ")
                                .append(listSet.getString("ACID")).append(", ")
                                .append(listSet.getString("TRACK_CNT")).append(", ")
                                .append(listSet.getString("ST_TIME")).append(", ")
                                .append(listSet.getString("END_TIME")).append(", ")
                                .append(listSet.getString("ORIG_ST_TIME")).append(", ")
                                .append(listSet.getString("ORIG_END_TIME")).append(", ")
                                .append(listSet.getString("MAX_X")).append(", ")
                                .append(listSet.getString("MIN_X")).append(", ")
                                .append(listSet.getString("MAX_Y")).append(", ")
                                .append(listSet.getString("MIN_Y")).append(", ")
                                .append(listSet.getString("MAX_Z")).append(", ")
                                .append(listSet.getString("MIN_Z")).append(", ")
                                .append(listSet.getString("AC_EQUIP")).append(", ")
                                .append(listSet.getString("AC_TYPE")).append(", ")
                                .append(listSet.getString("DEST_FIX")).append(", ")
                                .append(listSet.getString("FLIGHT_TYPE")).append(", ")
                                .append(listSet.getString("ORIGIN_FIX")).append(", ")
                                .append(listSet.getString("GAP_VALUE")).append(", ")
                                .append(listSet.getString("MAX_X_SMO")).append(", ")
                                .append(listSet.getString("MIN_X_SMO")).append(", ")
                                .append(listSet.getString("MAX_Y_SMO")).append(", ")
                                .append(listSet.getString("MIN_Y_SMO")).append(", ")
                                .append(listSet.getString("MAX_Z_SMO")).append(", ")
                                .append(listSet.getString("MIN_Z_SMO")).append(", ")
                                .append(listSet.getString("TOD_TIME")).append(", ")
                                .append(listSet.getString("TOC_TIME")).append(", ")
                                .append(listSet.getString("TOC_ALT")).append(", ")
                                .append(listSet.getString("END_CENTER")).append(", ")
                                .append(listSet.getString("START_CENTER")).append(", ")
                                .append(listSet.getString("END_CENTER_TIME")).append(", ")
                                .append(listSet.getString("START_CENTER_TIME")).append(", ")
                                .append(Min_Z).append(", ")
                                .append(Max_Z).append(", ")
                                .append(minTime).append(", ")
                                .append(maxTime).append(", ")
                                .append(elapseTime).append(", ")
                                .append(avgClimbSpeed).append(", ")
                                .append(minGSpeed).append(", ")
                                .append(maxGSpeed).append("\n");
                    }
			}
            setReturnedString(sb.toString());
		} 
		
        catch (SQLException e) {
			System.err.println(e.toString());
		} 
		
        finally {
			if (stmt2 != null) {
				stmt2.close();
			}
		}           
	}
}