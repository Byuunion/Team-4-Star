package model;


public class SingleFlightData 
{
	private int AC_NUM;
	private String ACID;
	private int TRACK_CNT;
	private int ST_TIME;
	private int END_TIME;
	private int ORIG_ST_TIME;
	private int ORIG_END_TIME;
	private double MAX_X;
	private double MIN_X;
	private double MAX_Y;
	private double MIN_Y;
	private int MAX_Z;
	private int MIN_Z;
	private String AC_EQUIP;
	private String AC_TYPE;
	private String DEST_FIX;
	private String FLIGHT_TYPE;
	private String ORIGIN_FIX;
	private int GAP_VALUE;
	private double MAX_X_SMO;
	private double MIN_X_SMO;
	private double MAX_Y_SMO;
	private double MIN_Y_SMO;
	private int MAX_Z_SMO;
	private int MIN_Z_SMO;
	private int TOD_TIME;
	private int TOC_TIME;
	private int TOC_ALT;
	private String END_CENTER;
	private String START_CENTER;
	private int END_CENTER_TIME;
	private int START_CENTER_TIME;
	private int LOW_Z;
	private int HIGH_Z;
	private int LOW_TIME;
	private int HIGH_TIME;
	private int BETWEEN_TIME;
	private double AVG_CLIMB;
	private int LOW_GROUND_SPEED_SMO;
	private int HIGH_GROUND_SPEED_SMO;

	
	public SingleFlightData()
	{
	}
	

	public int getAC_NUM() 
	{
		return AC_NUM;
	}

	public void setAC_NUM(int aC_NUM) 
	{
		AC_NUM = aC_NUM;
	}

	public String getACID() 
	{
		return ACID;
	}

	public void setACID(String aCID) 
	{
		ACID = aCID;
	}

	public int getTRACK_CNT() 
	{
		return TRACK_CNT;
	}

	public void setTRACK_CNT(int tRACK_CNT) 
	{
		TRACK_CNT = tRACK_CNT;
	}

	public int getST_TIME() 
	{
		return ST_TIME;
	}

	public void setST_TIME(int sT_TIME) 
	{
		ST_TIME = sT_TIME;
	}

	public int getEND_TIME() 
	{
		return END_TIME;
	}

	public void setEND_TIME(int eND_TIME) 
	{
		END_TIME = eND_TIME;
	}

	public int getORIG_ST_TIME()
	{
		return ORIG_ST_TIME;
	}

	public void setORIG_ST_TIME(int oRIG_ST_TIME) 
	{
		ORIG_ST_TIME = oRIG_ST_TIME;
	}

	public int getORIG_END_TIME() 
	{
		return ORIG_END_TIME;
	}

	public void setORIG_END_TIME(int oRIG_END_TIME)
	{
		ORIG_END_TIME = oRIG_END_TIME;
	}

	public double getMAX_X()
	{
		return MAX_X;
	}

	public void setMAX_X(double mAX_X)
	{
		MAX_X = mAX_X;
	}

	public double getMIN_X() 
	{
		return MIN_X;
	}

	public void setMIN_X(double mIN_X) 
	{
		MIN_X = mIN_X;
	}

	public double getMAX_Y() 
	{
		return MAX_Y;
	}

	public void setMAX_Y(double mAX_Y) 
	{
		MAX_Y = mAX_Y;
	}

	public double getMIN_Y() 
	{
		return MIN_Y;
	}

	public void setMIN_Y(double mIN_Y) 
	{
		MIN_Y = mIN_Y;
	}

	public int getMAX_Z() 
	{
		return MAX_Z;
	}

	public void setMAX_Z(int mAX_Z) 
	{
		MAX_Z = mAX_Z;
	}

	public int getMIN_Z() {
		return MIN_Z;
	}

	public void setMIN_Z(int mIN_Z)
	{
		MIN_Z = mIN_Z;
	}

	public String getAC_EQUIP() 
	{
		return AC_EQUIP;
	}

	public void setAC_EQUIP(String aC_EQUIP) 
	{
		AC_EQUIP = aC_EQUIP;
	}

	public String getAC_TYPE() 
	{
		return AC_TYPE;
	}

	public void setAC_TYPE(String aC_TYPE) 
	{
		AC_TYPE = aC_TYPE;
	}

	public String getDEST_FIX()
	{
		return DEST_FIX;
	}

	public void setDEST_FIX(String dEST_FIX) 
	{
		DEST_FIX = dEST_FIX;
	}

	public String getFLIGHT_TYPE() 
	{
		return FLIGHT_TYPE;
	}

	public void setFLIGHT_TYPE(String fLIGHT_TYPE) 
	{
		FLIGHT_TYPE = fLIGHT_TYPE;
	}

	public String getORIGIN_FIX()
	{
		return ORIGIN_FIX;
	}

	public void setORIGIN_FIX(String oRIGIN_FIX)
	{
		ORIGIN_FIX = oRIGIN_FIX;
	}

	public int getGAP_VALUE()
	{
		return GAP_VALUE;
	}

	public void setGAP_VALUE(int gAP_VALUE) 
	{
		GAP_VALUE = gAP_VALUE;
	}

	public double getMAX_X_SMO()
	{
		return MAX_X_SMO;
	}

	public void setMAX_X_SMO(double mAX_X_SMO) 
	{
		MAX_X_SMO = mAX_X_SMO;
	}

	public double getMIN_X_SMO()
	{
		return MIN_X_SMO;
	}

	public void setMIN_X_SMO(double mIN_X_SMO) 
	{
		MIN_X_SMO = mIN_X_SMO;
	}

	public double getMAX_Y_SMO()
	{
		return MAX_Y_SMO;
	}

	public void setMAX_Y_SMO(double mAX_Y_SMO) 
	{
		MAX_Y_SMO = mAX_Y_SMO;
	}

	public double getMIN_Y_SMO() 
	{
		return MIN_Y_SMO;
	}

	public void setMIN_Y_SMO(double mIN_Y_SMO)
	{
		MIN_Y_SMO = mIN_Y_SMO;
	}

	public int getMAX_Z_SMO()
	{
		return MAX_Z_SMO;
	}

	public void setMAX_Z_SMO(int mAX_Z_SMO) 
	{
		MAX_Z_SMO = mAX_Z_SMO;
	}

	public int getMIN_Z_SMO()
	{
		return MIN_Z_SMO;
	}

	public void setMIN_Z_SMO(int mIN_Z_SMO) 
	{
		MIN_Z_SMO = mIN_Z_SMO;
	}

	public int getTOD_TIME() 
	{
		return TOD_TIME;
	}

	public void setTOD_TIME(int tOD_TIME) 
	{
		TOD_TIME = tOD_TIME;
	}

	public int getTOC_TIME()
	{
		return TOC_TIME;
	}

	public void setTOC_TIME(int tOC_TIME) 
	{
		TOC_TIME = tOC_TIME;
	}

	public int getTOC_ALT() 
	{
		return TOC_ALT;
	}

	public void setTOC_ALT(int tOC_ALT) 
	{
		TOC_ALT = tOC_ALT;
	}

	public String getEND_CENTER()
	{
		return END_CENTER;
	}

	public void setEND_CENTER(String eND_CENTER)
	{
		END_CENTER = eND_CENTER;
	}

	public String getSTART_CENTER() 
	{
		return START_CENTER;
	}

	public void setSTART_CENTER(String sTART_CENTER) 
	{
		START_CENTER = sTART_CENTER;
	}

	public int getEND_CENTER_TIME()
	{
		return END_CENTER_TIME;
	}

	public void setEND_CENTER_TIME(int eND_CENTER_TIME) 
	{
		END_CENTER_TIME = eND_CENTER_TIME;
	}

	public int getSTART_CENTER_TIME() 
	{
		return START_CENTER_TIME;
	}

	public void setSTART_CENTER_TIME(int sTART_CENTER_TIME)
	{
		START_CENTER_TIME = sTART_CENTER_TIME;
	}

	public int getLOW_Z()
	{
		return LOW_Z;
	}

	public void setLOW_Z(int lOW_Z) 
	{
		LOW_Z = lOW_Z;
	}

	public int getHIGH_Z() 
	{
		return HIGH_Z;
	}

	public void setHIGH_Z(int hIGH_Z) 
	{
		HIGH_Z = hIGH_Z;
	}

	public int getLOW_TIME()
	{
		return LOW_TIME;
	}

	public void setLOW_TIME(int lOW_TIME) 
	{
		LOW_TIME = lOW_TIME;
	}

	public int getHIGH_TIME() 
	{
		return HIGH_TIME;
	}

	public void setHIGH_TIME(int hIGH_TIME)
	{
		HIGH_TIME = hIGH_TIME;
	}

	public int getBETWEEN_TIME() 
	{
		return BETWEEN_TIME;
	}

	public void setBETWEEN_TIME(int bETWEEN_TIME) 
	{
		BETWEEN_TIME = bETWEEN_TIME;
	}

	public double getAVG_CLIMB()
	{
		return AVG_CLIMB;
	}

	public void setAVG_CLIMB(float aVG_CLIMB) 
	{
		AVG_CLIMB = aVG_CLIMB;
	}

	public int getLOW_GROUND_SPEED_SMO()
	{
		return LOW_GROUND_SPEED_SMO;
	}

	public void setLOW_GROUND_SPEED_SMO(int lOW_GROUND_SPEED_SMO)
	{
		LOW_GROUND_SPEED_SMO = lOW_GROUND_SPEED_SMO;
	}

	public int getHIGH_GROUND_SPEED_SMO() 
	{
		return HIGH_GROUND_SPEED_SMO;
	}

	public void setHIGH_GROUND_SPEED_SMO(int hIGH_GROUND_SPEED_SMO) 
	{
		HIGH_GROUND_SPEED_SMO = hIGH_GROUND_SPEED_SMO;
	}
	
	public String toString(){
		return "" + AC_NUM + ", " +
	           ACID + ", " +              
               TRACK_CNT + ", " +            
               ST_TIME + ", " +              
               END_TIME + ", " +             
               ORIG_ST_TIME + ", " +         
               ORIG_END_TIME + ", " +        
               MAX_X + ", " +             
               MIN_X + ", " +             
               MAX_Y + ", " +             
               MIN_Y + ", " +             
               MAX_Z + ", " +                
               MIN_Z + ", " +                
               AC_EQUIP + ", " +          
               AC_TYPE + ", " +           
               DEST_FIX + ", " +          
               FLIGHT_TYPE + ", " +       
               ORIGIN_FIX + ", " +        
               GAP_VALUE + ", " +            
               MAX_X_SMO + ", " +         
               MIN_X_SMO + ", " +         
               MAX_Y_SMO + ", " +         
               MIN_Y_SMO + ", " +         
               MAX_Z_SMO + ", " +            
               MIN_Z_SMO + ", " +            
               TOD_TIME + ", " +             
               TOC_TIME + ", " +             
               TOC_ALT + ", " +              
               END_CENTER + ", " +        
               START_CENTER + ", " +      
               END_CENTER_TIME + ", " +      
               START_CENTER_TIME + ", " +    
               LOW_Z + ", " +                
               HIGH_Z + ", " +               
               LOW_TIME + ", " +             
               HIGH_TIME + ", " +            
               BETWEEN_TIME + ", " +         
               AVG_CLIMB + ", " +          
               LOW_GROUND_SPEED_SMO + ", " + 
               HIGH_GROUND_SPEED_SMO;
	}

	
	public String getAC_NUMString()
	{
		return Integer.toString(AC_NUM);
	}
	
	public String getTRACK_CNTString() 
	{
		return Integer.toString(TRACK_CNT);
	}
	
	public String getST_TIMEString() 
	{
		return Integer.toString(ST_TIME);
	}
	
	public String getEND_TIMESZtring() 
	{
		return Integer.toString(END_TIME);
	}
	
	public String getORIG_ST_TIMEString()
	{
		return Integer.toString(ORIG_ST_TIME);
	}
	
	public String getORIG_END_TIMEString()
	{
		return Integer.toString(ORIG_END_TIME);
	}
	
	public String getMAX_XString()
	{
		return Double.toString(MAX_X);
	}
	
	public String getMIN_XString()
	{
		return Double.toString(MIN_X);
	}
	
	
	public String getMIN_YString()
	{
		return Double.toString(MIN_Y);
	}
	
	public String getMAX_YString()
	{
		return Double.toString(MAX_Y);
	}
	
	public String getMIN_ZString()
	{
		return Integer.toString(MIN_Z);
	}
	
	public String getGAP_VALUEString()
	{
		return Integer.toString(GAP_VALUE);
	}
	
	public String getMAX_X_SMOString()
	{
		return Double.toString(MAX_X_SMO);
	}
	
	public String getMIN_X_SMOString()
	{
		return Double.toString(MIN_X_SMO);
	}
	
	public String getMAX_Y_SMOString()
	{
		return Double.toString(MAX_Y_SMO);
	}
	
	public String getMIN_Y_SMOString()
	{
		return Double.toString(MIN_Y_SMO);
	}
	
	public String getMAX_Z_SMOString()
	{
		return Integer.toString(MAX_Z_SMO);
	}

	public String getMIN_Z_SMOString()
	{
		return Integer.toString(MIN_Z_SMO);
	}
	
	public String getTOD_TIMEString() 
	{
		return Integer.toString(TOD_TIME);
	}
	
	public String getTOC_TIMEString() 
	
	{
		return Integer.toString(TOC_TIME);
	}
	
	public String getTOC_ALTString()
	{
		return Integer.toString(TOC_ALT);
	}

	public String getEND_CENTER_TIMEString()
	{
		return Integer.toString(END_CENTER_TIME);
	}
	
	public String getSTART_CENTER_TIMEString()
	{
		return Integer.toString(START_CENTER_TIME);
	}
	
	public String getLOW_ZString()
	{
		return Integer.toString(LOW_Z);
	}

	public String getHIGH_ZString()
		{
			return Integer.toString(HIGH_Z);
		}

	public String getLOW_TIMEString()
	{
		return Integer.toString(LOW_TIME);
	}

	public String getHIGH_TIMEString()
	{
		return Integer.toString(HIGH_TIME);
	}
	
	public String getBETWEEN_TIMEString()
	{
		return Integer.toString(BETWEEN_TIME);
	}
	
	public String getAVG_CLIMBString()
	{
		return Double.toString(AVG_CLIMB);
	}
	
	public String getLOW_GROUND_SPEED_SMOString()
	{
		return Integer.toString(LOW_GROUND_SPEED_SMO);
	}
	
	public String getHIGH_GROUND_SPEED_SMOString()
	{
		return Integer.toString(HIGH_GROUND_SPEED_SMO);
	}
}
