package Mark1;

import java.util.ArrayList;
import java.util.Arrays;

public class InstanceOfData {
	
	private String ACID;
	private ArrayList<String> info;
	
	public InstanceOfData(String ACID, String[] info) {
		this.ACID = ACID;
		this.info = new ArrayList<String>(Arrays.asList(info));
		
	}
	
	public String getACID() {
		return ACID;
	}

	public void setACID(String ACID) {
		this.ACID = ACID;
	}

	public ArrayList<String> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<String> info) {
		this.info = info;
	}

	public String toString() {
		String ret = ACID + ": \t";
		for(int i = 0; i < info.size(); i++) {
			ret += info.get(i) + ", ";
		}
		return ret;
	}


}
