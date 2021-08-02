package main.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class View implements SettingsListener{

	private JFrame frmFourcs;
	JPanel innerMainPanel;
	private static View thisView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					thisView= new View();
					thisView.frmFourcs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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
		frmFourcs.setBounds(0, 0, 1024, 768);
		frmFourcs.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmFourcs.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		frmFourcs.getContentPane().add(mainPanel, "name_514852363105400");
		mainPanel.setLayout(null);

		JPanel left_options_Panel = new JPanel();
		left_options_Panel.setToolTipText("");
		left_options_Panel.setBounds(0, 0, 189, 740);
		left_options_Panel.setBackground(new Color(1,58,32));
		mainPanel.add(left_options_Panel);


		JPanel settingsPannel = new JPanel();
		settingsPannel.setBorder(new EmptyBorder(25, 0, 0, 0));
		settingsPannel.setBounds(10, 38, 160, 240);
		settingsPannel.setBackground(new Color(0,0,0,0));
		left_options_Panel.add(settingsPannel);

		JLabel settingJL = new JLabel("Settings");
		settingJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		settingJL.setHorizontalTextPosition(SwingConstants.CENTER);
		settingJL.setFont(new Font("Arial", Font.BOLD, 15));
		settingJL.setHorizontalAlignment(SwingConstants.CENTER);
		settingJL.setForeground(Color.lightGray);
		settingJL.setBorder(new EmptyBorder(10, 0, 10, 0) );
		settingsPannel.setLayout(new BoxLayout(settingsPannel, BoxLayout.Y_AXIS));

		SettingsPanel settingsPanel = new SettingsPanel(thisView);
		settingsPanel.setVisible(false);
		
		settingJL.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e)
			{

				settingsPanel.setVisible(true);
				settingJL.setForeground(Color.white);
				
				frmFourcs.revalidate();
				



			}
		});


		settingsPannel.add(settingJL);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.lightGray);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
		settingsPannel.add(lblNewLabel);

		JPanel upperJpannel = new JPanel();
		upperJpannel.setBounds(187, 0, 833, 54);
		upperJpannel.setBackground(new Color(83,176,133));

		mainPanel.add(upperJpannel);
		upperJpannel.setLayout(new BorderLayout(0, 0));

		JLabel timeAndDateLabel = new JLabel("");
		timeAndDateLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
		timeAndDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);




		upperJpannel.add(timeAndDateLabel, BorderLayout.EAST);

		 innerMainPanel = new JPanel();
		innerMainPanel.setBounds(187, 54, 833, 686);
		mainPanel.add(innerMainPanel);
		innerMainPanel.setLayout(new BorderLayout(0, 0));
	
		innerMainPanel.add(settingsPanel, BorderLayout.CENTER);
	}

	@Override
	public void imageFolderPathChanged(Path i_Path) {
		// TODO tell controller
		
	}
}
