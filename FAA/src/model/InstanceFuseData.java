package model;

public class InstanceFuseData {
	
	private String AC_NUM;
	private Integer Start_Time;
	private Integer End_Time;
	private Integer Start_End_Time_Diff;
	private Integer Actual_Dept_Time;
	private Integer Orig_Start_Time;
	private Integer Ground_Speed;
	private Integer Start_Alt;
	private Integer End_Alt;
	private Integer Start_End_Alt_Diff;
	private String[] AC_List_Info; 

	public InstanceFuseData(String aC_NUM, Integer start_Time, Integer end_Time, Integer start_End_Diff, Integer actual_Dept_Time, Integer orig_Start_Time, Integer ground_Speed, Integer start_Alt, Integer end_Alt, String[] aC_List_Info) {
		super();
		AC_NUM = aC_NUM;
		Start_Time = start_Time;
		End_Time = end_Time;
		Start_End_Time_Diff = End_Time - Start_Time;
		Actual_Dept_Time = actual_Dept_Time;
		Orig_Start_Time = orig_Start_Time;
		Ground_Speed = ground_Speed;
		Start_Alt = start_Alt;
		End_Alt = end_Alt;
		Start_End_Alt_Diff = End_Alt - Start_Alt;
		AC_List_Info = aC_List_Info;
	}

	public String getAC_NUM() {
		return AC_NUM;
	}

	public void setAC_NUM(String aC_NUM) {
		AC_NUM = aC_NUM;
	}

	public Integer getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(Integer start_Time) {
		Start_Time = start_Time;
	}

	public Integer getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(Integer end_Time) {
		End_Time = end_Time;
	}

	public Integer getStart_End_Time_Diff() {
		return Start_End_Time_Diff;
	}

	public void setStart_End_Time_Diff(Integer start_End_Time_Diff) {
		Start_End_Time_Diff = start_End_Time_Diff;
	}

	public Integer getActual_Dept_Time() {
		return Actual_Dept_Time;
	}

	public void setActual_Dept_Time(Integer actual_Dept_Time) {
		Actual_Dept_Time = actual_Dept_Time;
	}

	public Integer getOrig_Start_Time() {
		return Orig_Start_Time;
	}

	public void setOrig_Start_Time(Integer orig_Start_Time) {
		Orig_Start_Time = orig_Start_Time;
	}

	public Integer getGround_Speed() {
		return Ground_Speed;
	}

	public void setGround_Speed(Integer ground_Speed) {
		Ground_Speed = ground_Speed;
	}

	public Integer getStart_Alt() {
		return Start_Alt;
	}

	public void setStart_Alt(Integer start_Alt) {
		Start_Alt = start_Alt;
	}

	public Integer getEnd_Alt() {
		return End_Alt;
	}

	public void setEnd_Alt(Integer end_Alt) {
		End_Alt = end_Alt;
	}

	public Integer getStart_End_Alt_Diff() {
		return Start_End_Alt_Diff;
	}

	public void setStart_End_Alt_Diff(Integer start_End_Alt_Diff) {
		Start_End_Alt_Diff = start_End_Alt_Diff;
	}

	public String[] getAC_List_Info() {
		return AC_List_Info;
	}

	public void setAC_List_Info(String[] aC_List_Info) {
		AC_List_Info = aC_List_Info;
	}
	
	
}
