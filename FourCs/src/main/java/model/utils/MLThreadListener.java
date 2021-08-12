package main.java.model.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDateTime;

import net.sf.javaml.core.Dataset;

public interface MLThreadListener
{
	void KmeansFinished(String i_Category,BufferedImage i_Image, Path i_ImagePath,Color i_AverageColor,LocalDateTime i_TimeStamp, Double i_Imperfection);
	void ClusteringError(Path imagePath);

	
	

}
