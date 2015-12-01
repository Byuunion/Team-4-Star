package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// readFromFile stub

public class Model {

	private static ArrayList<InstanceFuseData> universeFuseData;
	private static ArrayList<InstanceFuseData> galaxyFuseData;

	private InstanceFuseData AC_List;
	private InstanceFuseData AC_Track;
	
	public Model() {
		universeFuseData = new ArrayList<InstanceFuseData>();
		galaxyFuseData = new ArrayList<InstanceFuseData>();
	}
	
	public Model(File file) throws IOException {
		universeFuseData = new ArrayList<InstanceFuseData>();
		galaxyFuseData = new ArrayList<InstanceFuseData>();
		try {
			readFromFile(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setACList(InstanceFuseData AC_List){
		this.AC_List = AC_List;
	}
	
	public InstanceFuseData getACList() {
		return AC_List;
	}
	
	public InstanceFuseData getACTrack() {
		return AC_Track;
	}
	
	private void readFromFile(File file) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String element;
			String sepparator = ",";
			while((element = br.readLine()) != null) {
				String[] temp = element.split(sepparator);
				InstanceFuseData ACList = new InstanceFuseData(temp[0], Arrays.copyOfRange(temp, 1, temp.length));
				universeFuseData.add(ACList);
				InstanceFuseData ACTrack = Routine.predict(ACList);
				universeFuseData.add(ACTrack);
				System.out.println(ACTrack);
				galaxyFuseData.add(ACTrack);
			}
			br.close();
		} catch (FileNotFoundException e) {
			throw e;
		}
	}

	public boolean printUniverseACTrack() {
		System.out.println("-------------------------");
		if(universeFuseData == null || universeFuseData.size() < 1){
			System.out.println("Universe - EMPTY");
			return true;
		}
		for(InstanceFuseData dta : universeFuseData) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean printGalaxyACTrack() {
		System.out.println("-------------------------");
		if(galaxyFuseData == null || galaxyFuseData.size() < 1) {
			System.out.println("Galaxy - EMPTY");
			return true;
		}
		for(InstanceFuseData dta : galaxyFuseData) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean clearUniverseACTrack() {
		if(universeFuseData == null || universeFuseData.size() < 1) {
			return true;
		}
		universeFuseData = new ArrayList<InstanceFuseData>();
		return false;
	}
	
	public boolean filterGalaxy(String str) {
		boolean hasChanged = false;
		for(InstanceFuseData dta: universeFuseData) {
			if(!dta.toString().contains(str)) {
				galaxyFuseData.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	
	public boolean filterGalaxy(int index, String str) {
		boolean hasChanged = false;
		if(index == 0) {
			for(InstanceFuseData dta: universeFuseData) {
				if(!dta.toString().contains(str)) {
					galaxyFuseData.remove(dta);
					hasChanged = true;
				}
			}
		}
		for(InstanceFuseData dta: universeFuseData) {
			if(!dta.toString().contains(str)) {
				galaxyFuseData.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
}
