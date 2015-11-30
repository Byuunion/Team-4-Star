package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	
	private static Model Model_Of_Table;
	
	public static void main(String[] args) throws IOException {
		
		java.io.File file = new java.io.File(args[0]);
		System.out.println(file.getAbsolutePath());
		
		if(args.length <= 0 || file == null)  {
			throw new IOException("FileNotFoundException");
		}
		else {
			Model_Of_Table = new Model(file);
		}
		
		Model_Of_Table.printUniverseACTrack();
		Model_Of_Table.printGalaxyACTrack();
		Model_Of_Table.filterGalaxy("1");
		Model_Of_Table.printGalaxyACTrack();
	}

}
