package main.java.model.utils;

import java.nio.file.Path;

import net.sf.javaml.core.Dataset;

public interface MLThreadListener
{
	void KmeansFinished(Dataset[] i_Clusters);
	void ClusteringError(Path imagePath);
	
	

}
