package main.java.view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.security.Timestamp;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class GemCardJP extends JPanel {

	

	
	public GemCardJP(BufferedImage i_image, Path i_ImagePath, Color i_ImageAvColor,Timestamp i_timestamp) {
		setBounds(new Rectangle(0, 0, 833, 300));
		setLayout(null);
		
		JLabel pictureLabel = new JLabel("");
		pictureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pictureLabel.setPreferredSize(new Dimension(640, 480));
		pictureLabel.setMinimumSize(new Dimension(640, 480));
		pictureLabel.setMaximumSize(new Dimension(640, 480));
		pictureLabel.setBounds(new Rectangle(0, 0, 640, 480));
		pictureLabel.setBorder(new EmptyBorder(15, 15, 15, 0));
		pictureLabel.setBounds(30, 30, 320, 240);
		pictureLabel.setIcon(new ImageIcon(i_image));
		add(pictureLabel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setMaximumSize(new Dimension(640, 480));
		infoPanel.setBounds(394, 30, 405, 240);
		add(infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(categoryPanel);
		
		JLabel categoryFinalLabel = new JLabel("Gategory");
		categoryFinalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryPanel.add(categoryFinalLabel);
		
		JLabel categoryLabelForDisplay = new JLabel("");
		categoryLabelForDisplay.setText(i_ImagePath.toString());
		categoryPanel.add(categoryLabelForDisplay);
		
		JPanel averageColorLabel = new JPanel();
		averageColorLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(averageColorLabel);
		
		JLabel avColorFinalLabel = new JLabel("Average Color");
		averageColorLabel.add(avColorFinalLabel);
		
		JLabel avColorForDisplay = new JLabel("");
		avColorForDisplay.setForeground(Color.RED);
		avColorForDisplay.setPreferredSize(new Dimension(50, 20));
		avColorForDisplay.setMaximumSize(new Dimension(50, 50));
		avColorForDisplay.setMinimumSize(new Dimension(50, 0));
		avColorForDisplay.setBounds(new Rectangle(0, 0, 50, 50));
		avColorForDisplay.setBackground(Color.RED);
		averageColorLabel.add(avColorForDisplay);
		
		JPanel ImageNamePanel = new JPanel();
		ImageNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(ImageNamePanel);
		
		JLabel PictureNameFinalLabel = new JLabel("Picture's Name");
		ImageNamePanel.add(PictureNameFinalLabel);
		
		JLabel picNameForDisplayLabel = new JLabel("");
		picNameForDisplayLabel.setText(i_ImagePath.toString());
		ImageNamePanel.add(picNameForDisplayLabel);
		
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(timePanel);
		
		JLabel timeFinalLabel = new JLabel("Inserted at");
		timePanel.add(timeFinalLabel);
		
		JLabel timeLabel = new JLabel("");
		timeLabel.setText(i_timestamp.toString());
		timePanel.add(timeLabel);

	}
}
