package main.java.model.utils;

import java.awt.image.BufferedImage;

import net.sf.javaml.clustering.KMeans;

public class MLFunctionalities extends Thread {
	private BufferedImage image;

	public MLFunctionalities(BufferedImage i_image) {
		image = i_image;
		setDaemon(true);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	private void cuttingEdges() {
		int newWidth, newHeight;
		int oldWidth = image.getWidth(), oldHeight = image.getHeight();

		int clr = image.getRGB(0, 0);
		int prevRed = (clr & 0x00ff0000) >> 16, prevGreen = (clr & 0x00ff0000) >> 16,
				prevBlue = (clr & 0x00ff0000) >> 16;

		for (int width = 0; width < oldWidth; width++) {
			for (int height = 0; height < oldHeight; height++) {

				clr = image.getRGB(width, height);
				int red = (clr & 0x00ff0000) >> 16;
				int green = (clr & 0x0000ff00) >> 8;
				int blue = clr & 0x000000ff;
				
				//if((red>prevRed+10||red>prevRed)

			}
		}

	}

}
