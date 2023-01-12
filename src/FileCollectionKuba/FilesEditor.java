package FileCollectionKuba;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FilesEditor {
	
	public static List<File> fileList = new LinkedList<>();
	
	public static void putFileToList(File newFile) {
		for(int i=0; i<fileList.size(); i++) {
			if(fileList.get(i).getName()==newFile.getName()) {
				System.out.println("FILE WITH THIS NAME ALREADY EXISTS");
			}
		}
		fileList.add(newFile);
	}
	
	public static void showAllFiles(){
		for(int i=0; i<fileList.size(); i++) {
			System.out.println(fileList.get(i));
		}
	}
	/*
	 * FOR NOW I HAVE A PROBREM DEALING WITH MAP
	static HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
	
	public static void putFileToMap(File newFile) {
		int i = hashMap.values().size();
		hashMap.put(i+1, newFile.getName());
	}
	
	//RETURNING FILE NAME BY GIVING ITS INDEX
	public static String selectFileFromMap(int mapKey) {
		
	}
	*/
}
