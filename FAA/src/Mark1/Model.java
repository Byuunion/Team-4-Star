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

	private static ArrayList<InstanceACList> Array_List_AC_List;
	private static ArrayList<InstanceACTrack> Universe_AC_Track;
	private static ArrayList<InstanceACTrack> Galaxy_AC_Track;
	
	public Model() {
		Array_List_AC_List = new ArrayList<InstanceACList>();
		Universe_AC_Track = new ArrayList<InstanceACTrack>();
		Galaxy_AC_Track = new ArrayList<InstanceACTrack>();
	}
	
	public Model(File file) throws IOException {
		Array_List_AC_List = new ArrayList<InstanceACList>();
		Universe_AC_Track = new ArrayList<InstanceACTrack>();
		Galaxy_AC_Track = new ArrayList<InstanceACTrack>();
		try {
			readFromFile(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void readFromFile(File file) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String element;
			String sepparator = ",";
			while((element = br.readLine()) != null) {
				String[] temp = element.split(sepparator);
				InstanceACList ACList = new InstanceACList(temp[0], Arrays.copyOfRange(temp, 1, temp.length));
				Array_List_AC_List.add(ACList);
				InstanceACTrack ACTrack = Routine.predict(ACList);
				Universe_AC_Track.add(ACTrack);
				Galaxy_AC_Track.add(ACTrack);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean printUniverseACTrack() {
		System.out.println("-------------------------");
		if(Array_List_AC_List == null || Array_List_AC_List.size() < 1){
			System.out.println("Universe - EMPTY");
			return true;
		}
		for(InstanceACList dta : Array_List_AC_List) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean printGalaxyACTrack() {
		System.out.println("-------------------------");
		if(Galaxy_AC_Track == null || Galaxy_AC_Track.size() < 1) {
			System.out.println("Galaxy - EMPTY");
			return true;
		}
		for(InstanceACTrack dta : Galaxy_AC_Track) {
			System.out.println(dta.toString());
		}
		return false;
	}
	
	public boolean clearUniverseACTrack() {
		if(Array_List_AC_List == null || Array_List_AC_List.size() < 1) {
			return true;
		}
		Array_List_AC_List = new ArrayList<InstanceACList>();
		return false;
	}
	
	public boolean filterGalaxy(String str) {
		boolean hasChanged = false;
		for(InstanceACList dta: Array_List_AC_List) {
			if(!dta.toString().contains(str)) {
				Galaxy_AC_Track.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	
	public boolean filterGalaxy(int index, String str) {
		boolean hasChanged = false;
		if(index == 0) {
			for(InstanceACList dta: Array_List_AC_List) {
				if(!dta.toString().contains(str)) {
					Galaxy_AC_Track.remove(dta);
					hasChanged = true;
				}
			}
		}
		for(InstanceACList dta: Array_List_AC_List) {
			if(!dta.toString().contains(str)) {
				Galaxy_AC_Track.remove(dta);
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	
	
}
