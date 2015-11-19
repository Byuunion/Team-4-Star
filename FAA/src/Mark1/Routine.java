package Mark1;

import java.util.Arrays;

public abstract class Routine {
	
	private static InstanceACTrack AC_Track;
	
	public static InstanceACTrack predict(InstanceACList AC_List) {
		String AC_Num = "";
		String[] info = new String[AC_List.getInfo().size()];
		if(AC_List.getAC_NUM().equals("1")) {
			if(AC_List.getInfoElement(3).equals("5")) {
				info[0] = "5";
				instantiateACTrack("1", info);
				return AC_Track;
			}
		}
		return AC_Track;
	}
	
	public static void instantiateACTrack(String ACNum, String[] info) {
		AC_Track = new InstanceACTrack(ACNum, info);
	}

}
