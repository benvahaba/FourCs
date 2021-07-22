package main.java.model.utils;

import net.sf.javaml.core.Dataset;

public interface MLThreadListener
{
	void KmeansFinished(Dataset[] i_Clusters);
	
	

}
