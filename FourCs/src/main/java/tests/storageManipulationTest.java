package main.java.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import main.java.controller.Controller;
import main.java.model.Model;
import main.java.model.utils.ImageFoldierListener;
import main.java.model.utils.LocalStorageManipulation;

class storageManipulationTest {
	
	///test

	LocalStorageManipulation localStorageManipulation;




	@Test
	void imageLocalPathBefore() {
		
		LocalStorageManipulation localStorageManipulation = null;
		try {
			 localStorageManipulation = new LocalStorageManipulation();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(localStorageManipulation.checkIfImagesLocalPathExists())
			System.out.println("local path exitst");
		else {
			System.out.println("local path DONT exitst\"");
		}
		try {
			System.out.println("image path: "+localStorageManipulation.getImagesFolderPath());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			localStorageManipulation.InsertNewImagesFolderPath("C:\\Users\\ben's home\\Desktop\\FourCsTempImageFolder");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		localStorageManipulation.checkIfImagesLocalPathExists();
		try {
			System.out.println("image path: "+localStorageManipulation.getImagesFolderPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	void FoldierEvents()
	{
		String path="C:\\Users\\ben's home\\Desktop\\FourCsTempImageFolder";
		LocalStorageManipulation localStorageManipulation = null;
		
		try {
			localStorageManipulation = new LocalStorageManipulation();
			localStorageManipulation.InsertNewImagesFolderPath(path);
			Controller controller = new Controller();
			ImageFoldierListener imageFoldierListener = new ImageFoldierListener(new Model(controller),path);
			imageFoldierListener.run();
		
			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Test
	void BiggerTestWithEmptyController()
	{
		Controller controller = new Controller();
		Model model = new Model(controller);
	}

}
