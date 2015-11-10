package Mark1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {

	private static ArrayList<InstanceOfData> Universe_Of_Data;
	private static ArrayList<InstanceOfData> Galaxy_Of_Data;
	
	public Model(File file) throws IOException {
		Universe_Of_Data = new ArrayList<InstanceOfData>();
		Galaxy_Of_Data = new ArrayList<InstanceOfData>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String element;
			String sepparator = ",";
			while((element = br.readLine()) != null) {
				String[] temp = element.split(sepparator);
				Universe_Of_Data.add(new InstanceOfData(temp[0], Arrays.copyOfRange(temp, 1, temp.length)));
			}
			Galaxy_Of_Data = new ArrayList<InstanceOfData>(Universe_Of_Data);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean printUniverse() {
		System.out.println("-------------------------");
		if(Universe_Of_Data == null || Universe_Of_Data.size() < 1){
			System.out.println("Universe - EMPTY");
			return true;
		}
		for(InstanceOfData dta : Universe_Of_Data) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean printGalaxy() {
		System.out.println("-------------------------");
		if(Galaxy_Of_Data == null || Galaxy_Of_Data.size() < 1) {
			System.out.println("Galaxy - EMPTY");
			return true;
		}
		for(InstanceOfData dta : Galaxy_Of_Data) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean clearUniverse() {
		if(Universe_Of_Data == null || Universe_Of_Data.size() < 1) {
			return true;
		}
		Universe_Of_Data = new ArrayList<InstanceOfData>();
		return false;
	}
	
	public InstanceOfData getInstanceUniverseOfData(int index) {
		return Universe_Of_Data.get(index);
	}
	
	public boolean filterGalaxy(String str) {
		boolean hasChanged = false;
		for(InstanceOfData dta: Universe_Of_Data) {
			if(!dta.toString().contains(str)) {
				Galaxy_Of_Data.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	
	public boolean filterGalaxy(int index, String str) {
		boolean hasChanged = false;
		if(index == 0) {
			for(InstanceOfData dta: Universe_Of_Data) {
				if(!dta.toString().contains(str)) {
					Galaxy_Of_Data.remove(dta);
					hasChanged = true;
				}
			}
		}
		for(InstanceOfData dta: Universe_Of_Data) {
			if(!dta.toString().contains(str)) {
				Galaxy_Of_Data.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	
	
}
