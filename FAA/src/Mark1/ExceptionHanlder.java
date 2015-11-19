package Mark1;

import java.io.*;

public abstract class ExceptionHanlder {
	
	public static void Handle(Exception e) {
		if(e.instanceOf(FileNotFoundException)) {
			//respond
		}
		if(e.instanceOf(StackException)) {
			//response
		}
	}

}
