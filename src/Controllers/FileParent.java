package Controllers;

import java.io.File;
import java.io.IOException;

//TODO: complete implementation, to readonly etc.

public class FileParent {
	public FileParent(String fileName) {
		newFileMethod(fileName);
	}
	
	private void newFileMethod(String fileName) {
		try {
			//TODO: printing file in a specific directory ex.
			//"C:\\Users\\MyName\\filename.txt"
			File newFile = new File(fileName);
			if(newFile.exists())
				System.out.println("FILE ALREADY EXISTS");
			newFile.createNewFile();
		}catch(IOException e) {
			System.out.println("AN ERROR OCCURED - IOEXCEPTION");
			e.printStackTrace();
		}
	}
}
