package main.java.model.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.weka.WekaClusterer;
import weka.clusterers.XMeans;

public class MLThread extends Thread {
	private BufferedImage image;
	private Dataset data;
	private Dataset[] clusters;
	private boolean work = true;
	private MLThreadListener listener;
	//white avarage 157.5   155.625   157.375 

	///// temps. delete later


	public static int numOfPictures=0;
	public long lredAv = 0, lgreenAv = 0, lblueAv = 0;

	//// temps. delete later

	private final int maxCentroids = 4, iterations = 100;

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
			creatingDataSet();
			applyKmeans();
			work = false;
			int change=0;
			WhiteAverage(clusters, change);
			System.out.println(lredAv+","+lgreenAv+","+lblueAv );

		}

	}

	private void creatingDataSet() {
		data = new DefaultDataset();

		for (int width = 0; width < image.getWidth(); width++) {
			for (int height = 0; height < image.getHeight(); height++) {

				int clr = image.getRGB(width, height);
				double[] values = new double[] { (clr & 0x00ff0000) >> 16, (clr & 0x0000ff00) >> 8, clr & 0x000000ff };
				Instance instance = new DenseInstance(values);

				data.add(instance);
			}
		}
	}

	private void applyKmeans() {
		XMeans KMeans = new XMeans();
		try {
			KMeans.setMaxIterations(iterations);
			KMeans.setMinNumClusters(maxCentroids);
			KMeans.setMaxNumClusters(maxCentroids);

			Clusterer jmlxm = new WekaClusterer(KMeans);
			clusters = jmlxm.cluster(data);

			listener.KmeansFinished(clusters);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	////// tests
	private void WhiteAverage(Dataset[] i_Clusters, int iter) {
		long lred = 0, lgreen = 0, lblue = 0;
		for (Instance dataset : i_Clusters[iter]) {
			int rgbIter = 0;
			for (double color : dataset) {
				switch (rgbIter) {
				case 0: {
					lred = lred + (long) color;

					break;
				}
				case 1: {
					lgreen = lgreen + (long) color;

					break;
				}
				case 2: {
					lblue = lblue + (long) color;
					break;
				}

				}
				rgbIter++;

			}
		}
		lredAv=lredAv+lred/i_Clusters[iter].size();
		lgreenAv =lgreenAv+lred/i_Clusters[iter].size();
		lblueAv = lblueAv+lblue/i_Clusters[iter].size();

	}

	////// tests end

	public void Stop() {
		work = false;
	}

}