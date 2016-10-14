package main;

import javax.swing.text.View;

public class Main {
	
	private static int speed = 1;

	public static void main(String[] args) {
		
		// THIS IS PSUEDO CODE FOR NOW
		
		Model model = new Model();
		View view = new View();
		
		
		while (true) {
			
			for (int i = 0; i < speed; i++) {
				model.update();
			}
			
			view.update(model);
		}

	}

}
