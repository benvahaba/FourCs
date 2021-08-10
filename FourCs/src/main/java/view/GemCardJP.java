package main.java.view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;

public class GemCardJP extends JPanel {

	private Dimension cardDimension = new Dimension(833, 260);
	

	
	public GemCardJP(BufferedImage i_image, Path i_ImagePath, Color i_ImageAvColor,LocalDateTime i_timestamp) {
		
		setPreferredSize(cardDimension);
		setMaximumSize(cardDimension);

		setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel pictureLabel = new JLabel("");
		pictureLabel.setLocation(10, 10);
		pictureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pictureLabel.setSize(new Dimension(320, 240));
		pictureLabel.setPreferredSize(new Dimension(320, 240));


		pictureLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

		Image dimg = i_image.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(),
		        Image.SCALE_SMOOTH);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		pictureLabel.setIcon(new ImageIcon(dimg));
	
		add(pictureLabel);
		
		JPanel infoPanel = new JPanel();

		infoPanel.setBounds(225, 0, 225, 0);

		add(infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(categoryPanel);
		
		JLabel categoryFinalLabel = new JLabel("Gategory");
		categoryFinalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryPanel.add(categoryFinalLabel);
		
		JLabel categoryLabelForDisplay = new JLabel("");
		//TODO implement category
		categoryLabelForDisplay.setText("needs to be impelemted");
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
		picNameForDisplayLabel.setText(i_ImagePath.getFileName().toString());
		ImageNamePanel.add(picNameForDisplayLabel);
		
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(timePanel);
		
		JLabel timeFinalLabel = new JLabel("Inserted at");
		timePanel.add(timeFinalLabel);
		
		JLabel timeLabel = new JLabel("");
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		timeLabel.setText(i_timestamp.format(dateTimeFormatter));
		timePanel.add(timeLabel);
		
		JPanel imperfectionPanel = new JPanel();
		imperfectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoPanel.add(imperfectionPanel);
		
		JLabel imperfectionFinalLabel = new JLabel("Imperfection percentage");
		imperfectionPanel.add(imperfectionFinalLabel);
		
		JLabel imperfectionLabel = new JLabel("");
		imperfectionPanel.add(imperfectionLabel);

	}
}
