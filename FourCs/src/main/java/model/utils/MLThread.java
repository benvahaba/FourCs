package main.java.model.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.XMeans;
import weka.core.parser.java_cup.internal_error;

public class MLThread extends Thread {
	private BufferedImage image;
	private boolean work = true;
	private MLThreadListener listener;
	// white avarage 157.5 155.625 157.375

	///// temps. delete later

	static int imageIterator = 0;
	//// temps. delete later

	private final int maxCentroidsInitial = 4, maxCentroidsAfterFiltered = 2, iterations = 100;

	/**
	 * @param i_image
	 * @param i_Listener
	 */
	public MLThread(BufferedImage i_image, MLThreadListener i_Listener) {
		image = i_image;
		setDaemon(true);
		listener = i_Listener;

	}

	@Override
	public void run() {
		while (work) {

			try {
				Dataset filteredDataset = calculateAveragesAndRemoveRedundant(
						applyKmeans(creatingDataSet(), maxCentroidsInitial));

				applySecondKmeans(filteredDataset);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			work = false;

		}

	}

	private Dataset creatingDataSet() {
		Dataset data = new DefaultDataset();

		for (int width = 0; width < image.getWidth(); width++) {
			for (int height = 0; height < image.getHeight(); height++) {

				int clr = image.getRGB(width, height);
				double[] values = new double[] { (clr & 0x00ff0000) >> 16, (clr & 0x0000ff00) >> 8, clr & 0x000000ff };
				Instance instance = new DenseInstance(values);

				data.add(instance);
			}
		}

		if (data.isEmpty()) {
			System.out.println(" data empty");
		}
		return data;
	}

	private Dataset[] applyKmeans(Dataset dataset, int i_centroids) throws Exception {
//		XMeans KMeans = new XMeans();
//		Dataset[] clusters = null;
//			try {
//				KMeans.setMaxIterations(iterations);
//
//			KMeans.setMinNumClusters(i_centroids);
//			KMeans.setMaxNumClusters(i_centroids);
//
//			Clusterer jmlxm = new WekaClusterer(KMeans);
//			 clusters = jmlxm.cluster(dataset);
//			
//			} catch (Exception e) {
//				throw e;
//				
//			}
//
//			return clusters;
//			
//		
		/* Load a dataset */
		Clusterer km = new KMeans(i_centroids, iterations);

		/*
		 * Cluster the data, it will be returned as an array of data sets, with each
		 * dataset representing a cluster.
		 */
		Dataset[] clusters = km.cluster(dataset);

		return clusters;

	}

	////// tests
	private Dataset calculateAveragesAndRemoveRedundant(Dataset[] i_Clusters) {

		for (Dataset dataset : i_Clusters) {
			Color averageColor = averageCalculation(dataset);

			if (inColorRange(averageColor))
				return dataset;

		}
		System.out.println("bad averages ");
		for (Dataset dataset : i_Clusters) {
			Color averageColor = averageCalculation(dataset);
			System.out.println(averageColor.toString());

		}
		return null;

	}

	private Color averageCalculation(Dataset dataset) {

		float red = 0, green = 0, blue = 0;
		for (Instance instance : dataset) {
			int rgbIter = 0;
			for (double color : instance) {
				switch (rgbIter) {
				case 0: {
					red = red + (float) color;

					break;
				}
				case 1: {
					green = green + (float) color;

					break;
				}
				case 2: {
					blue = blue + (float) color;
					break;
				}

				}
				rgbIter++;

			}
		}

		return new Color((int) (red / dataset.size()), (int) (green / dataset.size()), (int) (blue / dataset.size()));
	}

	private void applySecondKmeans(Dataset datasets) throws Exception {
		synchronized (this) {
			Dataset[] clusters = applyKmeans(datasets, maxCentroidsAfterFiltered);

			Color color1 = averageCalculation(clusters[0]), color2 = averageCalculation(clusters[1]);

			boolean color1InRange=inColorRange(color1),color2InRange=inColorRange(color2);
			
			System.out.println(color1+ " "+clusters[0].size()+" "+color2+ " "+clusters[1].size());
			
			if(color1InRange &&color2InRange)
			{
				if(color1.getRed()+color1.getGreen()+color1.getBlue()>color2.getRed()+color2.getGreen()+color2.getBlue())
				{
					
					System.out.println(color2.toString()+ "cnflct");
				}
				else {
					System.out.println(color1.toString()+ "cnflct");
				}
				
			}
			else if (!color1InRange &&!color2InRange)
			{
				throw new Exception("after seonds kmeans. both colors NOT in range");
				
			}
			
			else if (inColorRange(color1)) {
				// return color 1
				System.out.println(color1.toString());
			} else {
				System.out.println(color2.toString());
			}

		}

	}
	
	private boolean inColorRange (Color i_color) {
		boolean colorInRange=false;
		
		if (i_color.getRed() < ColorsSpecs.GREEN_EMERALD_MAX.getRed()
				&& i_color.getRed() > ColorsSpecs.GREEN_EMERALD_MIN.getRed()
				&& i_color.getGreen() < ColorsSpecs.GREEN_EMERALD_MAX.getGreen()
				&& i_color.getGreen() > ColorsSpecs.GREEN_EMERALD_MIN.getGreen()
				&& i_color.getBlue() < ColorsSpecs.GREEN_EMERALD_MAX.getBlue()
				&& i_color.getBlue() > ColorsSpecs.GREEN_EMERALD_MIN.getBlue())
			colorInRange=true;
		
		
		return colorInRange;
		
	}

	public void Stop() {
		work = false;
	}

}