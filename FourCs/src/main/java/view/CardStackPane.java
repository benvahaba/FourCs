package main.java.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BoxLayout;

public class CardStackPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public CardStackPane() {
		setBounds(new Rectangle(0, 0, 833, 0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	

	}
	public void AddNewCard(GemCardJP gemCardJP)
	{
		add(gemCardJP,0);
		
		
		
	}
}
