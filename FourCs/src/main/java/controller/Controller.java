package main.java.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDateTime;

import main.java.model.Model;
import main.java.model.ModelListener;
import main.java.view.View;
import main.java.view.ViewListener;

public class Controller implements ModelListener,ViewListener {

	Model model;
	View view;
	private final String imageFolderErrorString="Invalid folder Path. choose a new one";
	
	public Controller(Model i_Model, View i_View)
	{
		model=i_Model;
		view=i_View;	
		view.addViewListener(this);
		model.AddModelListener(this);
		checkForValidImageFolderPath();
		
	}
	


	private void checkForValidImageFolderPath() {
		if(model.CheckIfImageFoldExists())
		{
			model.StartListeningToFolder();

		}
		else {
	
			model.ChangeImageDirPath(view.ChoosePicFolderPath(null).toString());
		}
		
	}


	@Override
	public void ViewImageFolderPathChanged(Path path) {
		model.ChangeImageDirPath(path.toString());
		
	}


	@Override
	public void ModelIllegalFolderPath() {
		view.ChoosePicFolderPath(imageFolderErrorString);
		
	}



	@Override
	public void ModelClusteringError(Path imagePath) {
		view.DisplayErrorMessage("Clustering error. try to take another picture",imagePath);
		
	}



	@Override
	public void ModelImageNameNotSupported(Path imagePath) {
		view.DisplayErrorMessage("Image name not supported. check your camera",imagePath);
		
	}



	@Override
	public void ModelDataFromPicture(String i_Category, BufferedImage i_Image, Path i_ImagePath,Color i_AverageColor,LocalDateTime i_TimeStamp, Double i_Imperfection) {
		view.NewGemInserted(i_Category,i_Image,i_ImagePath, i_AverageColor, i_TimeStamp,i_Imperfection);
		
	}





	








}
