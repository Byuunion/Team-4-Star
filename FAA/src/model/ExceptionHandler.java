package model;

import java.io.*;

public abstract class ExceptionHandler {
	
	public static void Handler(Exception e) {
		if(e.instanceOf(FileNotFoundException)) {
			//respond
		}
		if(e.instanceOf(StackException)) {
			//response
		}
	}

}
