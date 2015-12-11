package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TO DO FIX GENERATE GALAXY FILTER LIMIT APPENDING PROBLEM
 * DUPLICATES
 * @author BenzX
 *
 */
public class Model
{
	private File targetFile;
	//private ArrayList<SingleFlightData> universe;
	//private ArrayList<DataSet> universe;
	//private ArrayList<DataSet> galaxy;
	private ArrayList<SingleFlightData> universe;
	private ArrayList<SingleFlightData> galaxy;

	public Model(){
		universe = new ArrayList<SingleFlightData>();
		galaxy = new ArrayList<SingleFlightData>();
		universe = new ArrayList<SingleFlightData>();
	}


	public ArrayList<SingleFlightData> getUniverse(){
		return universe;
	}


	public ArrayList<SingleFlightData> getGalaxy(){
		return galaxy;
	}


	public void setFile(File newFile){	
		targetFile = newFile;
		try {
			generateUniverse();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile(){
		return targetFile;
	}


	public String generateGalaxyString(int limit){
		/*
		int strtEndDiff = getStart_Time()- getEnd_Time();
		int strtAlt = getStart_Alt() - getEnd_Alt();
		String neatString ="\n**************************************************************************************************************************************************************\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**  AC Number :        "+getAC_NUM()                                                           												           +" **\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**  AC List Info :     "+getAC_List_Info()                                                      										                   +" **\n"
						 +   "******************     																																	  **\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**  Start Time :       "+getStart_Time()+"        **  "+"  End_Time :            "+getEnd_Time()+       "  **  Start_End_Time_Diff:  "+strtEndDiff+"        **\n"        			 
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**************************************************************************************************************************************************************\n"
					     +   "**  Actual Dept.Time : "+getActual_Dept_Time()+"  **  "+"  Original_Start_Time : "+getOrig_Start_Time()+"  **  Ground_Speed:         "+getGround_Speed()+"  **\n" 
					     +   "**************************************************************************************************************************************************************\n"
					     +   "**************************************************************************************************************************************************************\n"
					     +   "**  Start Alt :        "+getStart_Alt()+"         **  "+"  End_Alt :             "+getEnd_Alt()        +"  **  Ground_Speed:         "+strtAlt+          "  **\n"
						 +   "**************************************************************************************************************************************************************\n"
						 +   "**************************************************************************************************************************************************************\n";;
*/		
						 
		StringBuilder sb = new StringBuilder();
		String display = "AC_NUM\tACID\tTRACK_CNT\tST_TIME\tEND_TIME\tORIG_ST_TIME\tORIG_END_TIME";
		sb.append(display);

		if(limit < universe.size()){
			
			for(int i = 0; i < limit; i++){
				sb.append("\n");
				sb.append(universe.get(i).getAC_NUM() + "\t");
				sb.append(universe.get(i).getACID() + "\t");
				sb.append(universe.get(i).getTRACK_CNT() + "\t");
				sb.append(universe.get(i).getST_TIME() + "\t");
				sb.append(universe.get(i).getEND_TIME() + "\t");
				sb.append(universe.get(i).getORIG_ST_TIME() + "\t");
				sb.append(universe.get(i).getORIG_END_TIME() + "\t");
				sb.append(universe.get(i).getMAX_X() + "\t");
				sb.append(universe.get(i).getMIN_X() + "\t");
				sb.append(universe.get(i).getMAX_Y() + "\t");
				sb.append(universe.get(i).getMIN_Y() + "\t");
				sb.append(universe.get(i).getMAX_Z() + "\t");
				sb.append(universe.get(i).getMIN_Z() + "\t");
				sb.append(universe.get(i).getAC_EQUIP() + "\t");
				sb.append(universe.get(i).getAC_TYPE() + "\t");
				sb.append(universe.get(i).getDEST_FIX() + "\t");
				sb.append(universe.get(i).getFLIGHT_TYPE() + "\t");
				sb.append(universe.get(i).getORIGIN_FIX() + "\t");
				sb.append(universe.get(i).getGAP_VALUE() + "\t");
				sb.append(universe.get(i).getMAX_X_SMO() + "\t");
				sb.append(universe.get(i).getMIN_X_SMO() + "\t");
				sb.append(universe.get(i).getMAX_Y_SMO() + "\t");
				sb.append(universe.get(i).getMIN_Y_SMO() + "\t");
				sb.append(universe.get(i).getMAX_Z_SMO() + "\t");
				sb.append(universe.get(i).getMIN_Z_SMO() + "\t");
				sb.append(universe.get(i).getTOD_TIME() + "\t");
				sb.append(universe.get(i).getTOC_TIME() + "\t");
				sb.append(universe.get(i).getTOC_ALT() + "\t");
				sb.append(universe.get(i).getSTART_CENTER() + "\t");
				sb.append(universe.get(i).getEND_CENTER_TIME() + "\t");
				sb.append(universe.get(i).getSTART_CENTER_TIME() + "\t");
				sb.append(universe.get(i).getLOW_Z() + "\t");
				sb.append(universe.get(i).getHIGH_Z() + "\t");
				sb.append(universe.get(i).getLOW_TIME() + "\t");
				sb.append(universe.get(i).getHIGH_TIME() + "\t");
				sb.append(universe.get(i).getBETWEEN_TIME() + "\t");
				sb.append(universe.get(i).getAVG_CLIMB() + "\t");
				sb.append(universe.get(i).getLOW_GROUND_SPEED_SMO() + "\t");
				sb.append(universe.get(i).getHIGH_GROUND_SPEED_SMO() + "\t");
			}
			return sb.toString();
		}
		else{
			JOptionPane.showMessageDialog(null, "Limit larger than elements of file.");
			return null;
		}
		
	}
	
	public void generateGalaxy(){
		//TODO
	}


	public void writeData(File selectedFile) throws IOException{
		StringBuilder sb = new StringBuilder();
        FileWriter writer = new FileWriter(selectedFile);
        galaxy = universe;
        System.out.println(galaxy.toString());
		for(SingleFlightData ifd: galaxy)
		{
			System.out.println(ifd.toString() + "\n");
			sb.append(ifd.toString() + "\n");
		}

		writer.write(sb.toString());
        writer.flush();
        writer.close();
	}


	public void generateUniverse() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(targetFile));
		String temp = reader.readLine();

		while((temp = reader.readLine()) != null){	
			SingleFlightData newFlight = new SingleFlightData();
			String[] data = temp.split(",");
			newFlight.setAC_NUM(Integer.parseInt(data[0]));
			newFlight.setACID(data[1]);
			newFlight.setTRACK_CNT(Integer.parseInt(data[2]));
			newFlight.setST_TIME(Integer.parseInt(data[3]));
			newFlight.setEND_TIME(Integer.parseInt(data[4]));
			newFlight.setORIG_ST_TIME(Integer.parseInt(data[5]));
			newFlight.setORIG_END_TIME(Integer.parseInt(data[6]));
			newFlight.setMAX_X(Double.parseDouble(data[7]));
			newFlight.setMIN_X(Double.parseDouble(data[8]));
			newFlight.setMAX_Y(Double.parseDouble(data[9]));
			newFlight.setMIN_Y(Double.parseDouble(data[10]));
			newFlight.setMAX_Z(Integer.parseInt(data[11]));
			newFlight.setMIN_Z(Integer.parseInt(data[12]));
			newFlight.setAC_EQUIP(data[13]);
			newFlight.setAC_TYPE(data[14]);
			newFlight.setDEST_FIX(data[15]);
			newFlight.setFLIGHT_TYPE(data[16]);
			newFlight.setORIGIN_FIX(data[17]);
			newFlight.setGAP_VALUE(Integer.parseInt(data[18]));
			newFlight.setMAX_X_SMO(Double.parseDouble(data[19]));
			newFlight.setMIN_X_SMO(Double.parseDouble(data[20]));
			newFlight.setMAX_Y_SMO(Double.parseDouble(data[21]));
			newFlight.setMIN_Y_SMO(Double.parseDouble(data[22]));
			newFlight.setMAX_Z_SMO(Integer.parseInt(data[23]));
			newFlight.setMIN_Z_SMO(Integer.parseInt(data[24]));
			newFlight.setTOD_TIME(Integer.parseInt(data[25]));
			newFlight.setTOC_TIME(Integer.parseInt(data[26]));
			newFlight.setTOC_ALT(Integer.parseInt(data[27]));
			newFlight.setEND_CENTER(data[28]);
			newFlight.setSTART_CENTER(data[29]);
			newFlight.setEND_CENTER_TIME(Integer.parseInt(data[30]));
			newFlight.setSTART_CENTER_TIME(Integer.parseInt(data[31]));
			newFlight.setLOW_Z(Integer.parseInt(data[32]));
			newFlight.setHIGH_Z(Integer.parseInt(data[33]));
			newFlight.setLOW_TIME(Integer.parseInt(data[34]));
			newFlight.setHIGH_TIME(Integer.parseInt(data[35]));
			newFlight.setBETWEEN_TIME(Integer.parseInt(data[36]));
			newFlight.setAVG_CLIMB(Float.parseFloat(data[37]));
			newFlight.setLOW_GROUND_SPEED_SMO(Integer.parseInt(data[38]));
			newFlight.setHIGH_GROUND_SPEED_SMO(Integer.parseInt(data[39]));

			universe.add(newFlight);
		}
		reader.close();
	}

	
	public ArrayList<SingleFlightData> getuniverse() {
		return universe;
	}


	public String generateUniverseString(){
		String display = "AC_NUM\tACID\tTRACK_CNT\tST_TIME\tEND_TIME\tORIG_ST_TIME\tORIG_END_TIME";

		for(int i = 0; i < 500; i++){
			display += "\n";
			display += (universe.get(i).getAC_NUM() + "\t");
			display += (universe.get(i).getACID() + "\t");
			display += (universe.get(i).getTRACK_CNT() + "\t");
			display += (universe.get(i).getST_TIME() + "\t");
			display += (universe.get(i).getEND_TIME() + "\t");
			display += (universe.get(i).getORIG_ST_TIME() + "\t");
			display += (universe.get(i).getORIG_END_TIME() + "\t");
			display += (universe.get(i).getMAX_X() + "\t");
			display += (universe.get(i).getMIN_X() + "\t");
			display += (universe.get(i).getMAX_Y() + "\t");
			display += (universe.get(i).getMIN_Y() + "\t");
			display += (universe.get(i).getMAX_Z() + "\t");
			display += (universe.get(i).getMIN_Z() + "\t");
			display += (universe.get(i).getAC_EQUIP() + "\t");
			display += (universe.get(i).getAC_TYPE() + "\t");
			display += (universe.get(i).getDEST_FIX() + "\t");
			display += (universe.get(i).getFLIGHT_TYPE() + "\t");
			display += (universe.get(i).getORIGIN_FIX() + "\t");
			display += (universe.get(i).getGAP_VALUE() + "\t");
			display += (universe.get(i).getMAX_X_SMO() + "\t");
			display += (universe.get(i).getMIN_X_SMO() + "\t");
			display += (universe.get(i).getMAX_Y_SMO() + "\t");
			display += (universe.get(i).getMIN_Y_SMO() + "\t");
			display += (universe.get(i).getMAX_Z_SMO() + "\t");
			display += (universe.get(i).getMIN_Z_SMO() + "\t");
			display += (universe.get(i).getTOD_TIME() + "\t");
			display += (universe.get(i).getTOC_TIME() + "\t");
			display += (universe.get(i).getTOC_ALT() + "\t");
			display += (universe.get(i).getEND_CENTER() + "\t");
			display += (universe.get(i).getSTART_CENTER() + "\t");
			display += (universe.get(i).getEND_CENTER_TIME() + "\t");
			display += (universe.get(i).getSTART_CENTER_TIME() + "\t");
			display += (universe.get(i).getLOW_Z() + "\t");
			display += (universe.get(i).getHIGH_Z() + "\t");
			display += (universe.get(i).getLOW_TIME() + "\t");
			display += (universe.get(i).getHIGH_TIME() + "\t");
			display += (universe.get(i).getBETWEEN_TIME() + "\t");
			display += (universe.get(i).getAVG_CLIMB() + "\t");
			display += (universe.get(i).getLOW_GROUND_SPEED_SMO() + "\t");
			display += (universe.get(i).getHIGH_GROUND_SPEED_SMO() + "\t");
		}
		
		return display;
	}
	 
	
	
	public Map<String, Integer> GetPlanes() {
		Map<String, Integer> planes = new HashMap<>();
		String plane = null;
		int size = universe.size();
		for (int i = 0; i < size; i++) {
			plane = universe.get(i).getAC_TYPE();
			if(planes.containsKey(plane)){
				planes.put(plane, planes.get(plane)+1);
			}else{
				planes.put(plane, 1);
			}
		}
				
		return planes;
	}

}
