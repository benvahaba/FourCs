package main.java.model;

import java.awt.Color;
import java.nio.file.Path;
import java.time.LocalDateTime;

import net.sf.javaml.core.Dataset;

public interface ModelListener
{

	void ModelIllegalFolderPath();
	 void ModelClusteringError(Path imagePath);
	 void ModelImageNameNotSupported(Path imagePath);
	 
	 void ModelDataFromPicture(Dataset i_Cluster,Color i_AverageColor,LocalDateTime i_TimeStamp);
	
	
	

}
