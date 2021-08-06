package main.java.model;

import java.nio.file.Path;

public interface ModelListener
{

	void ModelIllegalFolderPath();
	 void ModelClusteringError(Path imagePath);
	 void ModelImageNameNotSupported(Path imagePath);
	
	
	

}
