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
import java.io.File;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Rectangle;
import java.awt.Dimension;

public class View implements Runnable, SettingsListener {

	private JFrame frmFourcs;
	JPanel innerMainPanel;

	private JLabel settingJL;
	private final Color PressedLeftJLColor = new Color(0, 117, 64);
	private final Color leftJPColor = new Color(1, 58, 32);
	private ViewListener viewListener;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		initialize();

	}

	public void addViewListener(ViewListener i_ViewListener) {
		viewListener = i_ViewListener;
	}

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
		left_options_Panel.setBackground(leftJPColor);
		mainPanel.add(left_options_Panel);

		JPanel settingsPannel = new JPanel();
		settingsPannel.setPreferredSize(new Dimension(189, 740));
		settingsPannel.setBounds(new Rectangle(0, 0, 189, 0));
		settingsPannel.setAutoscrolls(true);
		settingsPannel.setBorder(new EmptyBorder(25, 0, 0, 0));
		settingsPannel.setBounds(10, 38, 160, 240);
		settingsPannel.setBackground(new Color(0, 0, 0, 0));
		left_options_Panel.add(settingsPannel);

		JLabel StatisticsJl = new JLabel("Statistics");
		StatisticsJl.setMaximumSize(new Dimension(189, 40));
		StatisticsJl.setPreferredSize(new Dimension(189, 13));
		StatisticsJl.setHorizontalAlignment(SwingConstants.CENTER);
		StatisticsJl.setAlignmentX(Component.CENTER_ALIGNMENT);
		StatisticsJl.setForeground(Color.lightGray);
		StatisticsJl.setBackground(PressedLeftJLColor);
		StatisticsJl.setHorizontalTextPosition(SwingConstants.CENTER);
		StatisticsJl.setFont(new Font("Arial", Font.BOLD, 15));
		StatisticsJl.setBorder(new EmptyBorder(10, 0, 10, 0));
		StatisticsJl.setOpaque(true);

		StatisticsJl.addMouseListener(new MouseListener() {

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

				settingJL.setBackground(leftJPColor);
				StatisticsJl.setBackground(PressedLeftJLColor);

				frmFourcs.revalidate();

			}
		});

		settingsPannel.add(StatisticsJl);

		settingJL = new JLabel("Settings");
		settingJL.setMaximumSize(new Dimension(189, 40));
		settingJL.setPreferredSize(new Dimension(189, 13));
		settingJL.setBounds(new Rectangle(0, 0, 189, 0));
		settingJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		settingJL.setHorizontalTextPosition(SwingConstants.CENTER);
		settingJL.setFont(new Font("Arial", Font.BOLD, 15));
		settingJL.setHorizontalAlignment(SwingConstants.CENTER);
		settingJL.setForeground(Color.lightGray);
		settingJL.setBorder(new EmptyBorder(10, 0, 10, 0));
		settingJL.setBackground(new Color(0, 0, 0, 0));
		settingJL.setOpaque(true);
		settingsPannel.setLayout(new BoxLayout(settingsPannel, BoxLayout.Y_AXIS));

		SettingsPanel settingsPanel = new SettingsPanel(this);
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
			public void mouseClicked(MouseEvent e) {

				settingsPanel.setVisible(true);

				settingJL.setBackground(PressedLeftJLColor);
				StatisticsJl.setBackground(leftJPColor);

				frmFourcs.revalidate();

			}
		});

		settingsPannel.add(settingJL);

		JPanel upperJpannel = new JPanel();
		upperJpannel.setBounds(187, 0, 833, 54);
		upperJpannel.setBackground(new Color(83, 176, 133));

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
		frmFourcs.setVisible(true);
	}

	@Override
	public void imageFolderPathChanged(Path i_Path) {
		viewListener.ViewImageFolderPathChanged(i_Path);

	}

	public Path ChoosePicFolderPath(String i_Message) {
		JFileChooser fileChooser = new JFileChooser();
		
		if(i_Message!=null)
		{
			fileChooser.setDialogTitle(i_Message);
			
		}
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = fileChooser.showOpenDialog(this.frmFourcs);
		
		while(option != JFileChooser.APPROVE_OPTION)
		{
			option = fileChooser.showOpenDialog(this.frmFourcs);

		}
		File file = fileChooser.getSelectedFile();
		return Path.of(file.getAbsolutePath());
	}

}
