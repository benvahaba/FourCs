package main.java.model;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import main.java.model.utils.ImageFoldierListener;
import main.java.model.utils.ImageListener;
import main.java.model.utils.ImageManipulation;
import main.java.model.utils.LocalStorageManipulation;


public class Model implements ImageListener
{
	private ModelListener controllerListener;
	private LocalStorageManipulation storageManipulation;
	private ImageFoldierListener imageFoldierListener;

	
	public Model(ModelListener modelListener) 
	{
		controllerListener = modelListener;
		try {
			storageManipulation= new LocalStorageManipulation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(storageManipulation.checkIfImagesLocalPathExists())
		{
			try {
				imageFoldierListener = new ImageFoldierListener(this ,storageManipulation.getImagesFolderPath());
				imageFoldierListener.run();
			} catch (FileNotFoundException e) {
				// TODO notify controller "illegal path"
				e.printStackTrace();
			}
			
			
		}
		else {
			//TODO notify controller
		}
		
		
		
		
	}
	public void ChangeImageDirPath(String i_Path)
	{
		try {
			storageManipulation.InsertNewImagesFolderPath(i_Path);
			imageFoldierListener.InsertNewImageDirPathAndRun(i_Path);	
		} catch (IOException e) {
			// TODO notify controller that the path is illegal
			e.printStackTrace();
		}
		
	}


	@Override
	public void NewImageInserted(Path ImagePath) {
		try {
			BufferedImage image = ImageManipulation.getImage(ImagePath);
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO tell controller that the image.name is not supported
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
