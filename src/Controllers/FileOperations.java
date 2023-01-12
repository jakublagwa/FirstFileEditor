package Controllers;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class FileOperations {
	
	//TRANSFORMING AN INPUTSTREAM TO STRING
	public String readFromInputStream(InputStream inputStream)
	throws IOException{
		StringBuilder resultStringBuilder = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new
				InputStreamReader(inputStream))){
			String line;
			while((line=br.readLine())!=null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
	
	//READING A FILE THAT IS AVAILABLE ON A CLASSPATH
	public void readingGivenFile() throws IOException {
		String expectedData = "some text";
		Class class1 = FileOperations.class;
		InputStream inputStream = class1.getResourceAsStream("FILENAME.STH");
		String data = readFromInputStream(inputStream);
		//ASSERT OBJECT??
		//Assert.assertThat(data, containsString(excpectedData));
	}
	
	//WRITE TO FILE
	//TODO: method to get as a argument file or sth else
	public void fileWriting(String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			fileWriter.write("SOMETHING IS WRITTEN HERE");
			fileWriter.close();
		}catch(IOException e) {
			System.out.println("AN ERROR OCCURED - IOEXCEPTION");
			e.printStackTrace();
		}
	}
	
	//READ A FILE
	public void readFile(File newFile) {
		try {
			Scanner scan = new Scanner(newFile);
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				System.out.println(data);
			}
			scan.close();
		}catch(FileNotFoundException e) {
			System.out.println("AN ERROR OCCURED - FILENOTFOUNDEXCEPTION");
			e.printStackTrace();
		}
	}
	
	//DELETE A FILE
	public void deleteFile(String fileName) {
		File newFile = new File(fileName);
		if(newFile.delete()) {
			System.out.println("FILE DELETED: " + fileName);
		}else {
			System.out.println("FAILED TO DELETE FILE:" + fileName);
		}
	}
	
	//DELETING A FOLDER
	//METHOD ARGUMENT IS A CLASSPATH
	public void deleteFolder(String classpathName) {
		File newFile = new File(classpathName);
		if(newFile.delete()) {
			System.out.println("DELETED THE FOLDER: " + newFile.getName());
		}else {
			System.out.println("FAILED TO DELETE THE FOLDER: " + newFile.getName());
		}
	}
}
