package main.java.tests;



import org.junit.jupiter.api.Test;

import main.java.view.View;

public class ViewTests 
{
	
	@Test
	public void viewtest()
	{
		
		
		View view = new View();
		view.run();
		System.out.println(view.ChoosePicFolderPath(null));
		while(true);
	
		
		
		
	}

}
