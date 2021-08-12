package main.java.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import main.java.model.utils.ImageFolderListener;
import main.java.model.utils.ImageListener;
import main.java.model.utils.ImageManipulation;
import main.java.model.utils.LocalStorageManipulation;
import main.java.model.utils.MLThread;
import main.java.model.utils.MLThreadListener;



//white average 157.5   155.625   157.375  


public class Model implements ImageListener, MLThreadListener {
	private ModelListener modelListener;
	private LocalStorageManipulation storageManipulation;
	private ImageFolderListener imageFoldierListener;
	
	

	public Model() {
	
		try {
			storageManipulation = new LocalStorageManipulation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void AddModelListener(ModelListener i_ModelListener) {
		modelListener=i_ModelListener;}

	public boolean CheckIfImageFoldExists()
	{
		if (storageManipulation.checkIfImagesLocalPathExists())
			return true;
		return false;
	}
	public void StartListeningToFolder()
	{
		try {
			imageFoldierListener = new ImageFolderListener(this, storageManipulation.getImagesFolderPath());
			imageFoldierListener.start();
	
		} catch (FileNotFoundException e) {
			modelListener.ModelIllegalFolderPath();
			e.printStackTrace();
		}
	}
	

	public void ChangeImageDirPath(String i_Path) {
		try {
			storageManipulation.InsertNewImagesFolderPath(i_Path);
			imageFoldierListener.InsertNewImageDirPathAndRun(i_Path);
		} catch (IOException e) {
			modelListener.ModelIllegalFolderPath();
			e.printStackTrace();
		}

	}

	@Override
	public void NewImageInserted(Path ImagePath) {
		try {
				BufferedImage image = ImageManipulation.getImage(ImagePath);
				MLThread ml = new MLThread(image, this,ImagePath);
				ml.start();
				


		} catch (IOException e) {
			modelListener.ModelImageNameNotSupported(ImagePath);
			e.printStackTrace();
		}

	}
	@Override
	public void ClusteringError(Path imagePath) {
		modelListener.ModelClusteringError(imagePath);
		
	}


	@Override
	public void KmeansFinished(String i_Category,BufferedImage i_Image, Path i_ImagePath,Color i_AverageColor,LocalDateTime i_TimeStamp, Double i_Imperfection) {
		modelListener.ModelDataFromPicture(i_Category,i_Image,i_ImagePath, i_AverageColor, i_TimeStamp,i_Imperfection);
		
	}





}