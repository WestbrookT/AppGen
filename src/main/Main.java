package main;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.View;

import command.LoadState;
import command.PauseState;
import command.SaveState;
import command.SpeedState;
import tile.WorldGrid;
import worldPanel.WorldPanel;



public class Main extends JFrame{
	
	private JButton LoadButton;
	private JButton SpeedButton;
	private JButton SaveButton;
	private JButton PauseButton;
	
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
		SpeedState speeder = new SpeedState(SpeedButton, speed, power);
		SpeedButton.addActionListener(speeder);
		SaveState saver = new SaveState(SaveButton);
		SaveButton.addActionListener(saver);
		PauseState pauser = new PauseState(PauseButton, speed, power);
		PauseButton.addActionListener(pauser);
		WorldGrid wg = new WorldGrid(50,20,10,20);
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
		add(panelCenter, BorderLayout.CENTER);
		WorldPanel wp = new WorldPanel(wg);
		panelCenter.add(wp);
		JPanel dummyPanel = new JPanel();
		dummyPanel.setBackground(Color.BLACK);
		panelCenter.add(dummyPanel);
	}
	
	public static void main(String[] args) {
		
		// THIS IS PSUEDO CODE FOR NOW
		Main window = new Main();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		
	}

}
