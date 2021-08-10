package main.java.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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



		
		JScrollPane scrollPane = new JScrollPane(innerJPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 innerJPanel.setLayout(new GridLayout(0, 1));
		 setPreferredSize(new Dimension(800, 200));
		 
		getParent().add(scrollPane);
			for(int i = 0 ; i<40;i++)
			{
				JButton button = new JButton();
				innerJPanel.add(button);
				
			}

	
	}
	public void AddNewCard(GemCardJP gemCardJP)
	{
		//innerJPanel.add(gemCardJP,0);
		
		
		for(int i = 0 ; i<40;i++)
		{
			JButton button = new JButton();
			innerJPanel.add(button);
			
		}
	


		
		
		
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

