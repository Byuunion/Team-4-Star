package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
	private File targetFile;
	private ArrayList<SingleFlightData> flights;
	private ArrayList<DataSet> universe;
	private ArrayList<DataSet> galaxy;

	public Model() {
		universe = new ArrayList<DataSet>();
		galaxy = new ArrayList<DataSet>();
		flights = new ArrayList<SingleFlightData>();
	}

	public ArrayList<DataSet> getUniverse() {
		return universe;
	}

	public ArrayList<DataSet> getGalaxy() {
		return galaxy;
	}

	public void setFile(File newFile) {
		targetFile = newFile;
		try {
			generateUniverse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return targetFile;
	}

	public String generateGalaxyString() {
		// TODO
		return null;
	}

	public void generateGalaxy(String[] filters) {
		// TODO
	}

	public void writeData(File selectedFile) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));

		for (DataSet ifd : galaxy) {
			String temp = ifd.toString().replace(" ", ",");
			writer.write(temp);
		}

		writer.close();
	}

	public void generateUniverse() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(targetFile));
		String temp = reader.readLine();

		while ((temp = reader.readLine()) != null) {
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

			flights.add(newFlight);
		}

		reader.close();
	}

	public ArrayList<SingleFlightData> getFlights() {
		return flights;
	}

	public String generateUniverseString() {
		String display = "AC_NUM\tACID\tTRACK_CNT\tST_TIME\tEND_TIME\tORIG_ST_TIME\tORIG_END_TIME";

		for (int i = 0; i < 500; i++) {
			display += "\n";
			display += (flights.get(i).getAC_NUM() + "\t");
			display += (flights.get(i).getACID() + "\t");
			display += (flights.get(i).getTRACK_CNT() + "\t");
			display += (flights.get(i).getST_TIME() + "\t");
			display += (flights.get(i).getEND_TIME() + "\t");
			display += (flights.get(i).getORIG_ST_TIME() + "\t");
			display += (flights.get(i).getORIG_END_TIME() + "\t");
			display += (flights.get(i).getMAX_X() + "\t");
			display += (flights.get(i).getMIN_X() + "\t");
			display += (flights.get(i).getMAX_Y() + "\t");
			display += (flights.get(i).getMIN_Y() + "\t");
			display += (flights.get(i).getMAX_Z() + "\t");
			display += (flights.get(i).getMIN_Z() + "\t");
			display += (flights.get(i).getAC_EQUIP() + "\t");
			display += (flights.get(i).getAC_TYPE() + "\t");
			display += (flights.get(i).getDEST_FIX() + "\t");
			display += (flights.get(i).getFLIGHT_TYPE() + "\t");
			display += (flights.get(i).getORIGIN_FIX() + "\t");
			display += (flights.get(i).getGAP_VALUE() + "\t");
			display += (flights.get(i).getMAX_X_SMO() + "\t");
			display += (flights.get(i).getMIN_X_SMO() + "\t");
			display += (flights.get(i).getMAX_Y_SMO() + "\t");
			display += (flights.get(i).getMIN_Y_SMO() + "\t");
			display += (flights.get(i).getMAX_Z_SMO() + "\t");
			display += (flights.get(i).getMIN_Z_SMO() + "\t");
			display += (flights.get(i).getTOD_TIME() + "\t");
			display += (flights.get(i).getTOC_TIME() + "\t");
			display += (flights.get(i).getTOC_ALT() + "\t");
			display += (flights.get(i).getEND_CENTER() + "\t");
			display += (flights.get(i).getSTART_CENTER() + "\t");
			display += (flights.get(i).getEND_CENTER_TIME() + "\t");
			display += (flights.get(i).getSTART_CENTER_TIME() + "\t");
			display += (flights.get(i).getLOW_Z() + "\t");
			display += (flights.get(i).getHIGH_Z() + "\t");
			display += (flights.get(i).getLOW_TIME() + "\t");
			display += (flights.get(i).getHIGH_TIME() + "\t");
			display += (flights.get(i).getBETWEEN_TIME() + "\t");
			display += (flights.get(i).getAVG_CLIMB() + "\t");
			display += (flights.get(i).getLOW_GROUND_SPEED_SMO() + "\t");
			display += (flights.get(i).getHIGH_GROUND_SPEED_SMO() + "\t");
		}

		display += "\n \n Number of Flights: " + flights.size();

		return display;
	}

	public Map<String, Integer> GetPlanes() {
		Map<String, Integer> planes = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = null;
		int size = flights.size();
		for (int i = 0; i < size; i++) {
			plane = flights.get(i).getAC_TYPE();
			if (planes.containsKey(plane)) {
				planes.put(plane, planes.get(plane) + 1);
			} else {
				planes.put(plane, 1);
			}
		}

		sortedMap = sortHashMap(planes);

		for (Map.Entry entry : sortedMap.entrySet()) {
			System.out.println((String) entry.getKey() + " " + (int) entry.getValue());
		}

		return sortedMap;
	}

	private static Map<String, Integer> sortHashMap(Map<String, Integer> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Integer>> list = 
			new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
