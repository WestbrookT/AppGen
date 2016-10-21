package main;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.View;

import command.LoadState;
import command.PauseState;
import command.SaveState;
import command.SpeedState;



public class Main extends JFrame{
	
	private JButton LoadButton;
	private JButton SpeedButton;
	private JButton SaveButton;
	private JButton PauseButton;
	
	private static int speed = 1;
	private static double power = 0;
	public Main() {
		super("Evolutionary Neural Control Simulator");
		
		//buttons for command panel
		JPanel panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new GridLayout(1, 4));
		panelNorth.setBackground(Color.YELLOW);
		LoadButton = new JButton("Load");
		panelNorth.add(LoadButton);
		SpeedButton = new JButton("Speed: x" + speed);
		panelNorth.add(SpeedButton);
		SaveButton = new JButton("Save");
		panelNorth.add(SaveButton);
		PauseButton = new JButton("Pause");
		panelNorth.add(PauseButton);
		LoadState loader = new LoadState(LoadButton);
		LoadButton.addActionListener(loader);
		SpeedState speeder = new SpeedState(SpeedButton, speed, power);
		SpeedButton.addActionListener(speeder);
		SaveState saver = new SaveState(SaveButton);
		SaveButton.addActionListener(saver);
		PauseState pauser = new PauseState(PauseButton, speed, power);
		PauseButton.addActionListener(pauser);
	}
	
	public static void main(String[] args) {
		
		// THIS IS PSUEDO CODE FOR NOW
		Main window = new Main();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		
	}

}
