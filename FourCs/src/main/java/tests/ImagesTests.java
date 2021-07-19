package main.java.tests;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import main.java.model.utils.ImageManipulation;

public class ImagesTests extends Canvas
{
	

	public void paint(Graphics g) {  
	    	  
		
		
		BufferedImage image;
		try {
			image = ImageManipulation.getImage(Path.of("C:\\\\Users\\\\vahab\\\\Desktop\\\\testFoldier\\\\sample_640×426.bmp"));

        BufferedImage result = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
	        Toolkit t=Toolkit.getDefaultToolkit();  
  
	        g.drawImage(result, 120,100,this); 
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          
	    }  
	@Test
	public void doWork() {  
	        ImagesTests m=new ImagesTests();  
	        JFrame f=new JFrame();  
	        f.add(m);  
	        f.setSize(400,400);  
	        f.setVisible(true);  
	        while(true)
	        {
	        	
	        }
	    } 
	
	
	}


