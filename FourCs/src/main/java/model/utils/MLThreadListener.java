package main.java.model.utils;

import java.awt.Color;
import java.nio.file.Path;
import java.time.LocalDateTime;

import net.sf.javaml.core.Dataset;

public interface MLThreadListener
{
	void KmeansFinished(Dataset i_Cluster,Color i_AverageColor,LocalDateTime i_TimeStamp);
	void ClusteringError(Path imagePath);
	
	

}
