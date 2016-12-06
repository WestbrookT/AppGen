package main;

import javax.swing.JFrame;
import Model.Model;
import View.View;

public class Main extends JFrame{
	public static void main(String[] args) throws InterruptedException {
		
		Model model = new Model(60, 30, 5, 29, 10, 10, 20);
		View view = new View(model);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(610, 720);
		view.setVisible(true);
		
		for (int i = 0; i < 1000000; i++) {
			
			model.advance();
			view.panel.repaint();
			view.pp.repaint();
			Thread.sleep(100);
			
		}
		
		
	}

}
