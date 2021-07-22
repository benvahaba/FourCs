package main.java.model.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class ImageManipulation
{
	
	public static BufferedImage getImage(Path i_Path) throws IOException
	{
		
		
		boolean isRegularExecutableFile;
		
		do {
			
			
			isRegularExecutableFile = Files.isRegularFile(i_Path) &
			         Files.isReadable(i_Path) & Files.isExecutable(i_Path);
			
		} while (!isRegularExecutableFile);
		
		BufferedImage img = null;
		try {
			 img = ImageIO.read(new File(i_Path.toString()));	
			
		} catch (IOException e) {
			throw e;
			// TODO: handle exception
		}
				
			return img;
	}

}
