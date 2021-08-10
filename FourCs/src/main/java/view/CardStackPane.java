package main.java.view;

import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class CardStackPane extends JPanel {
	JPanel innerJPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public CardStackPane() {
		
		setLayout(new GridLayout());
	
		
		 innerJPanel = new JPanel();
		 innerJPanel.setLayout(new BoxLayout(innerJPanel, BoxLayout.Y_AXIS));
		// Component cntrlComponent = new Componen

		
		JScrollPane scrollPane = new JScrollPane(innerJPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)
	
		add(scrollPane);
		revalidate();

	}
	public void AddNewCard(GemCardJP gemCardJP)
	{
		//innerJPanel.add(gemCardJP,0);

		revalidate();
		
		
		
	}
}
//public class CardStackPane extends JPanel {
//JPanel panel;
//
//public CardStackPane() {
//	setBounds(new Rectangle(0, 0, 833, 0));
//	setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//	
//	panel= new JPanel();
//
//	JScrollPane scrollPane = new JScrollPane(panel);
//	panel.setLayout(new BoxLayout(panel, BoxLayout._AXIS));
//
//
//}
//public void AddNewCard(GemCardJP gemCardJP)
//{
//	panel.add(gemCardJP,0);
//	
//	
//	
//}
//}

