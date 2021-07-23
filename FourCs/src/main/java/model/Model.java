package main.java.model;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import main.java.model.utils.ImageFoldierListener;
import main.java.model.utils.ImageListener;
import main.java.model.utils.ImageManipulation;
import main.java.model.utils.LocalStorageManipulation;
import main.java.model.utils.MLThread;
import main.java.model.utils.MLThreadListener;
import net.sf.javaml.core.Dataset;



//white avarage 157.5   155.625   157.375  


public class Model implements ImageListener, MLThreadListener {
	private ModelListener controllerListener;
	private LocalStorageManipulation storageManipulation;
	private ImageFoldierListener imageFoldierListener;
	
	
	//temps

	
	//temps end



	public Model(ModelListener modelListener) {
		controllerListener = modelListener;
		try {
			storageManipulation = new LocalStorageManipulation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (storageManipulation.checkIfImagesLocalPathExists()) {
			try {
				imageFoldierListener = new ImageFoldierListener(this, storageManipulation.getImagesFolderPath());
				imageFoldierListener.start();
			} catch (FileNotFoundException e) {
				// TODO notify controller "illegal path"
				e.printStackTrace();
			}

		} else {
			// TODO notify controller
		}

	}

	public void ChangeImageDirPath(String i_Path) {
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
				MLThread ml = new MLThread(image, this);
				ml.start();
				


		} catch (IOException e) {
			// TODO tell controller that the image.name is not supported
			e.printStackTrace();
		}

	}

	@Override
	public void KmeansFinished(Dataset[] i_Clusters) 
	{

		
		
	


		

	}

}