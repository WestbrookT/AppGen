package main;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.View;

import Model.Model;
import Model.WorldGrid;
import View.PopulationPanel;
import View.WorldPanel;
import command.LoadState;
import command.PauseState;
import command.SaveState;
import command.SpeedState;



public class Main extends JFrame{
	
	private JButton LoadButton;
	private JButton SpeedButton;
	private JButton SaveButton;
	private JButton PauseButton;
	
	private Model model;
	private WorldPanel panel;
	private PopulationPanel panel1;
	
	private static int speed = 1;
	private static double power = 0;
	public Main() {
		super("Evolutionary Neural Control Simulator");
		/*JPanel backPanel = new JPanel();
		backPanel.setLayout(new );
		*/
		//buttons for command panel
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new GridLayout(1, 4));
		panelNorth.setBackground(Color.YELLOW);

		
		
		
		model = new Model(60, 30, 1, 29, 5, 10, 50);

		LoadButton = new JButton("Load");
		panelNorth.add(LoadButton);
		SaveButton = new JButton("Save");
		panelNorth.add(SaveButton);
		SpeedButton = new JButton("Speed: x" + speed);
		panelNorth.add(SpeedButton);
		PauseButton = new JButton("Pause");
		panelNorth.add(PauseButton);
		LoadState loader = new LoadState(LoadButton);
		LoadButton.addActionListener(loader);
		SpeedState speeder = new SpeedState(SpeedButton, speed, power, model);
		SpeedButton.addActionListener(speeder);
		SaveState saver = new SaveState(SaveButton);
		SaveButton.addActionListener(saver);
		PauseState pauser = new PauseState(PauseButton, speed, power, model);
		PauseButton.addActionListener(pauser);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
		add(panelCenter, BorderLayout.CENTER);
		panel = new WorldPanel(model.getWorldGrid());
		panelCenter.add(panel);
		panel1 = new PopulationPanel(model.getWorldGrid());
		panelCenter.add(panel1);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		// THIS IS PSUEDO CODE FOR NOW
		Main window = new Main();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 700);
		window.setVisible(true);
		
		for (int i = 0; i < 1000000; i++) {
			
			window.model.advance();
			window.panel.repaint();
			window.panel1.repaint();
			Thread.sleep(100);
			
		}
		
		
	}

}
