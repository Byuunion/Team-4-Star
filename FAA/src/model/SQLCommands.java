package model;

import java.sql.*;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Math;


public class SQLCommands 
{
	private static String returnedString;
	private static Connection conn;
	private static String scenario;
	private static HashSet<Integer> mostCommonZs;


	public SQLCommands() 
	{
		setMostCommonZs(new HashSet<Integer>());
	}


	public static Connection getConnection() 
	{
		return conn;
	}


	public static void setConnection(Connection conn) 
	{
		SQLCommands.conn = conn;
	}


	public void setScenario(String sc) 
	{
		scenario = sc;
	}


	public String getScenario() 
	{
		return scenario;
	}


	public String getReturnedString() 
	{
		return returnedString;
	}


	public static void setReturnedString(String str) 
	{
		returnedString = str;
	}


	public void clear() 
	{
		returnedString = null;
	}


	public ResultSet query(String query) throws SQLException
	{
		Statement stmt = null;
		stmt = conn.createStatement();
		return stmt.executeQuery(query);
	}


	public ArrayList<String> pull(String element, ResultSet rs) throws SQLException
	{
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()) 
		{
			list.add(rs.getString(element));
		}

		return list;
	}


	@SuppressWarnings("unused")
	public static void queryTable() throws SQLException 
	{
		ArrayList<InstanceFuseData> row = new ArrayList<InstanceFuseData>();
		ArrayList<String> ac_Data = new ArrayList<String>();
		Statement stmt, stmt2 = null;
		int Max_Z, Min_Z;
		double minTime, maxTime, elapseTime, minGSpeed, maxGSpeed, avgClimbSpeed;
		boolean minNotFound, maxNotFound;
		StringBuilder sb = new StringBuilder();
		String query = "SELECT * FROM AC_LISTRW" + scenario;

		try 
		{
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			ResultSet listSet = stmt.executeQuery(query);

			while (listSet.next()) 
			{
				String acNum = listSet.getString("AC_NUM");
				String query2 = "SELECT ELAP_TIME, Z_VALUE, GROUND_SPEED_SMO FROM AC_TRKSRW" 
						+ scenario + " where AC_NUM = " + acNum;

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

				while(Track_Nums.next())
				{
					if(minNotFound) 
					{
						Min_Z = Track_Nums.getInt("Z_VALUE");
						minTime = Track_Nums.getInt("ELAP_TIME"); 
						minGSpeed = Track_Nums.getInt("GROUND_SPEED_SMO");
						minNotFound = false;
					}

					if(Track_Nums.getInt("Z_VALUE") <= Max_Z && maxNotFound == true)
					{	
						maxNotFound = false;
					}

					if(Track_Nums.getInt("Z_VALUE") > Max_Z && maxNotFound == true)
					{
						Max_Z = Track_Nums.getInt("Z_VALUE");
						maxTime = Track_Nums.getInt("ELAP_TIME");
						maxGSpeed = Track_Nums.getInt("GROUND_SPEED_SMO");
					}                               
				}

				elapseTime = maxTime - minTime;
				avgClimbSpeed = Math.abs((maxGSpeed - minGSpeed) / elapseTime);

				if(Min_Z + 3000 < Max_Z)
				{
					ac_Data.add(listSet.getString("AC_NUM"));
					ac_Data.add(listSet.getString("ACID"));
					ac_Data.add(listSet.getString("TRACK_CNT"));
					ac_Data.add(listSet.getString("ST_TIME"));
					ac_Data.add(listSet.getString("END_TIME"));
					ac_Data.add(listSet.getString("ORIG_ST_TIME"));
					ac_Data.add(listSet.getString("ORIG_END_TIME"));
					ac_Data.add(listSet.getString("MAX_X"));
					ac_Data.add(listSet.getString("MIN_X"));
					ac_Data.add(listSet.getString("MAX_Y"));
					ac_Data.add(listSet.getString("MIN_Y"));
					ac_Data.add(listSet.getString("MAX_Z"));
					ac_Data.add(listSet.getString("MIN_Z"));
					ac_Data.add(listSet.getString("AC_EQUIP"));
					ac_Data.add(listSet.getString("AC_TYPE"));
					ac_Data.add(listSet.getString("DEST_FIX"));
					ac_Data.add(listSet.getString("FLIGHT_TYPE"));
					ac_Data.add(listSet.getString("ORIGIN_FIX"));
					ac_Data.add(listSet.getString("GAP_VALUE"));
					ac_Data.add(listSet.getString("MAX_X_SMO"));
					ac_Data.add(listSet.getString("MIN_X_SMO"));
					ac_Data.add(listSet.getString("MAX_Y_SMO"));
					ac_Data.add(listSet.getString("MIN_Y_SMO"));
					ac_Data.add(listSet.getString("MAX_Z_SMO"));
					ac_Data.add(listSet.getString("MIN_Z_SMO"));
					ac_Data.add(listSet.getString("TOD_TIME"));
					ac_Data.add(listSet.getString("TOC_TIME"));
					ac_Data.add(listSet.getString("TOC_ALT"));
					ac_Data.add(listSet.getString("END_CENTER"));
					ac_Data.add(listSet.getString("START_CENTER"));
					ac_Data.add(listSet.getString("END_CENTER_TIME"));
					ac_Data.add(listSet.getString("START_CENTER_TIME"));

					String[] ac_Array = ac_Data.toArray(new String[ac_Data.size()]);

					row.add(new InstanceFuseData(listSet.getString("AC_Num"), listSet.getInt("ST_TIME"),
							listSet.getInt("END_TIME"), listSet.getInt("END_TIME") - listSet.getInt("ST_TIME"),
							listSet.getInt("ORIG_ST_TIME"), listSet.getInt("ORIG_END_TIME"),
							(int) maxGSpeed, Min_Z, Max_Z, ac_Array));
				}
			}

			setReturnedString(sb.toString());
		} 		
		catch(SQLException e) 
		{
			System.err.println(e.toString());
		} 
		finally 
		{
			if(stmt2 != null)
			{
				stmt2.close();
			}
		}           
	}


	public static HashSet<Integer> getMostCommonZs() 
	{
		return mostCommonZs;
	}


	public static void setMostCommonZs(HashSet<Integer> mostCommonZs) 
	{
		SQLCommands.mostCommonZs = mostCommonZs;
	}

}
