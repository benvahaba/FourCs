package main.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.color.ColorSpace;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class View {

	private JFrame frmFourcs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					View window = new View();
					window.frmFourcs.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFourcs = new JFrame();
		frmFourcs.setTitle("FourC's");
		frmFourcs.getContentPane().setBackground(Color.WHITE);
		frmFourcs.setResizable(false);
		frmFourcs.setBounds(100, 100, 713, 528);
		frmFourcs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFourcs.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 224, 122));
		frmFourcs.getContentPane().add(panel, "name_514852363105400");
		panel.setLayout(null);
		
		JPanel left_options_Panel = new JPanel();
		left_options_Panel.setToolTipText("");
		left_options_Panel.setBounds(0, 0, 179, 500);
		left_options_Panel.setBackground(new Color(1,58,32));
		panel.add(left_options_Panel);
	
		
		JPanel settingsPannel = new JPanel();
		settingsPannel.setBounds(10, 10, 160, 240);
		settingsPannel.setBackground(new Color(0,0,0,0));
		left_options_Panel.setLayout(null);
		left_options_Panel.add(settingsPannel);
		GridBagLayout gbl_settingsPannel = new GridBagLayout();
		gbl_settingsPannel.columnWidths = new int[]{36, 108, 45, 0};
		gbl_settingsPannel.rowHeights = new int[]{13, 0, 0, 0, 0, 0};
		gbl_settingsPannel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_settingsPannel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		settingsPannel.setLayout(gbl_settingsPannel);
		
		JLabel settingJL = new JLabel("Settings");
		settingJL.setHorizontalTextPosition(SwingConstants.CENTER);
		settingJL.setFont(new Font("Arial", Font.BOLD, 15));
		settingJL.setHorizontalAlignment(SwingConstants.CENTER);
		settingJL.setForeground(Color.lightGray);
	
		GridBagConstraints gbc_settingJL = new GridBagConstraints();
		gbc_settingJL.anchor = GridBagConstraints.NORTHWEST;
		gbc_settingJL.insets = new Insets(0, 0, 5, 5);
		gbc_settingJL.gridx = 1;
		gbc_settingJL.gridy = 0;
		settingsPannel.add(settingJL, gbc_settingJL);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.lightGray);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		settingsPannel.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(80,200,120));
		scrollPane.setBounds(181, 0, 528, 500);
		panel.add(scrollPane);
	}

}
