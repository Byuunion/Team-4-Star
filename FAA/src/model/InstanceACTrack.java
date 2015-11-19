package model;

import java.util.ArrayList;
import java.util.Arrays;

public class InstanceACTrack {

	private String AC_NUM;
	private ArrayList<String> info;
	
	public InstanceACTrack(String AC_NUM, String[] info) {
		this.AC_NUM = AC_NUM;
		this.info = new ArrayList<String>(Arrays.asList(info));
		
	}
	
	public String getAC_NUM() {
		return AC_NUM;
	}

	public void setAC_NUM(String AC_NUM) {
		this.AC_NUM = AC_NUM;
	}

	public ArrayList<String> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<String> info) {
		this.info = info;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(AC_NUM);
		sb.append(": ");
		for(String st: info) {
			sb.append(" " + st);
		}
		return sb.toString();
	}


}
