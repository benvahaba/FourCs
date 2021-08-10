package main.java.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;

public class SettingsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	SettingsListener settingsListener;
	JPanel jPanel;
	
	public SettingsPanel(SettingsListener i_settingsListener) 
	{
		jPanel=this;
		settingsListener=i_settingsListener;
		setBorder(new EmptyBorder(25, 0, 25, 0));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{143, 163, 0};
		gridBagLayout.rowHeights = new int[]{30, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel changePathLabel = new JLabel("Change image folder path");
		changePathLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		changePathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changePathLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
		changePathLabel.setAlignmentX(0.5f);
		GridBagConstraints gbc_changePathLabel = new GridBagConstraints();
		gbc_changePathLabel.insets = new Insets(0, 0, 5, 0);
		gbc_changePathLabel.gridx = 1;
		gbc_changePathLabel.gridy = 0;
		
		changePathLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            int option = fileChooser.showOpenDialog(jPanel);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	            
	     
	               settingsListener.imageFolderPathChanged(Path.of(file.getAbsolutePath()));

			}
		}});
		
		
		add(changePathLabel, gbc_changePathLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblNewLabel_1.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

	}

}
