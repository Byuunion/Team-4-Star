package model;

import java.io.*;

import javax.swing.JOptionPane;

public abstract class ExceptionHandler {
	
	private static final String FileNotFoundException = null;

	public static void Handle(Exception e) {
		if(e instanceof FileNotFoundException) {
			JOptionPane.showMessageDialog(null,"You cant do that.", "Error Box",JOptionPane.ERROR_MESSAGE);
			//Response Code goes here
		}
		if(e instanceof ArrayIndexOutOfBoundsException){
			JOptionPane.showMessageDialog(null,"You cant do that.", "Error Box",JOptionPane.ERROR_MESSAGE);
			//Response Code goes here
		}
	}

}
