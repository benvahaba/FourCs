package main.java.driver;

import main.java.controller.Controller;
import main.java.model.Model;
import main.java.view.View;

public class MainEntry {

	public static void main(String[] args) {
		
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);
		view.addViewListener(controller);
		model.AddModelListener(controller);
		controller.checkForValidImageFolderPath();
		

	}

}
