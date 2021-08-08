package main.java.tests;

import org.junit.Test;

import main.java.controller.Controller;
import main.java.model.Model;
import main.java.view.View;

public class OverAllTest
{
	@Test
	public void mainTest()
	{
	View view = new View();
	Model model = new Model();
	Controller controller = new Controller(model, view);
	view.run();
	while (true) {}
	
	}

}
