package main.java.controller;

import java.nio.file.Path;

import main.java.model.Model;
import main.java.model.ModelListener;
import main.java.view.View;
import main.java.view.ViewListener;

public class Controller implements ModelListener,ViewListener {

	Model model;
	View view;
	
	public Controller(Model i_Model, View i_View)
	{
		model=i_Model;
		view=i_View;
		
		
		
	}
	
	
	@Override
	public void ImageFoldierPathChanged(Path path) {
		model.ChangeImageDirPath(path.toString());
		
	}

}
