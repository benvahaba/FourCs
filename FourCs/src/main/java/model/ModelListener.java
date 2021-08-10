package main.java.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDateTime;

public interface ModelListener
{

	void ModelIllegalFolderPath();
	 void ModelClusteringError(Path imagePath);
	 void ModelImageNameNotSupported(Path imagePath);
	 
	 void ModelDataFromPicture(BufferedImage i_image, Path i_ImagePath,Color i_AverageColor,LocalDateTime i_TimeStamp);
	
	
	

}
