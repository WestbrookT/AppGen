package main;

import javax.swing.JFrame;
import Model.Model;
import View.View;


public class Main {



	public static void main(String [] args) throws InterruptedException{
		Model model = new Model(80, 40, 5, 29, 10, 10, 20);
		View view = new View(model);
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(810, 900);
		view.setVisible(true);
		
		for (int i = 0; i < 1000000; i++){
			model.advance();
			view.panel.repaint();
			view.pp.repaint();
			Thread.sleep(50);
		}
	}
}
