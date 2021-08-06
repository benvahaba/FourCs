package main.java.controller;

import java.nio.file.Path;

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
		// TODO notify view
		
	}



	@Override
	public void ModelImageNameNotSupported(Path imagePath) {
		// TODO notify view
		
	}





	








}
