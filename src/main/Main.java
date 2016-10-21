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
		LoadButton.addActionListener(new LoadState());
		SpeedButton.addActionListener(new SpeedState());
		SaveButton.addActionListener(new SaveState());
		PauseButton.addActionListener(new PauseState());
		
	}
	
	public static void main(String[] args) {
		
		// THIS IS PSUEDO CODE FOR NOW
		Main window = new Main();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		

	}

}
