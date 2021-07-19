package main.java.model.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class ImageManipulation
{
	
	public static BufferedImage getImage(Path i_Path) throws IOException
	{	
			BufferedImage img = ImageIO.read(new File(i_Path.toString()));		
			return img;
	}

}
