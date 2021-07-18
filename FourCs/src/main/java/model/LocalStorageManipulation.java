package main.java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class LocalStorageManipulation 
{
	
	
	private final String localFileName = "ImagesFoldierPath.txt";
	private File localFile;

	private String imagesFolderPath="";
	public  String getImagesFolderPath() throws FileNotFoundException 
	{
		try {
			localStorageScanner = new Scanner(localFile);
		} catch (FileNotFoundException e) {
			throw e;
		}
		if(localStorageScanner.hasNext())
		{
			imagesFolderPath=localStorageScanner.nextLine();
			return imagesFolderPath;
			
		}
		
		
		return imagesFolderPath;
	}
	private Scanner localStorageScanner = null;

	public LocalStorageManipulation() throws IOException, FileNotFoundException{

		localFile = new File(localFileName);

		
	
			try {
				if (localFile.createNewFile() == false)
				{
					localStorageScanner = new Scanner(localFile);
					if (localStorageScanner.hasNextLine()) {
						imagesFolderPath=localStorageScanner.nextLine();
						
					}				
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}


		finally
		{
			if(localStorageScanner!=null)
			{
				localStorageScanner.close();
			}
		
			
		}

	}

	public Boolean checkIfImagesLocalPathExists() {
		Boolean PathExists = false;
		
		if(!imagesFolderPath.isEmpty())
		{
			PathExists=true;
		}

		return PathExists;
		//

	}
	public Boolean InsertNewImagesFolderPath (String i_path) throws IOException 
	{
		
		Boolean pathSavedBoolean=true;
		FileWriter fileWriter = null;
		Path imagesDirPath;

			
		
		try {
			if(!i_path.endsWith("\\"))
			{
			
				imagesDirPath =Paths.get(i_path+"\\");
				
			}
			else {
				 imagesDirPath =Paths.get(i_path);
				
			}
			
			
			
			
			
		} catch (InvalidPathException e) {
			// TODO: handle exception
			e.printStackTrace();
			pathSavedBoolean=false;
			return pathSavedBoolean;
		}
		
		try {
			fileWriter= new FileWriter(localFile);
			fileWriter.write(imagesDirPath.toString());

		
		
		
		} catch (IOException e) {
			
			throw e;
		}
		finally {
			fileWriter.flush();
			fileWriter.close();
			
		}
		
		
		
		
		return pathSavedBoolean;

		
	}

}
