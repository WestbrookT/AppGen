package main;

import java.awt.*;

import javax.swing.JFrame;

import Model.Model;
import Model.WorldGrid;
import View.AnalysisPanel;
import View.PopulationPanel;
import View.WorldPanel;
import View.View;
import command.LoadState;
import command.PauseState;
import command.ResetState;
import command.SaveState;
import command.SpeedState;



public class Main extends JFrame{
	
	
	
	private Model model;
	private WorldPanel panel;
	private PopulationPanel pp;
	private AnalysisPanel ap;
	
	private static int speed = 1;

	public Main() {}
//		super("Evolutionary Neural Control Simulator");
//		/*JPanel backPanel = new JPanel();
//		backPanel.setLayout(new );
//		*/
//		//buttons for command panel
//		JPanel panelNorth = new JPanel();
//		add(panelNorth, BorderLayout.NORTH);
//		panelNorth.setLayout(new GridLayout(1, 5));
//		panelNorth.setBackground(Color.YELLOW);
//
//		
//		
//		
//		model = new Model(60, 30, 5, 29, 10, 10, 20);
//
//		LoadButton = new JButton("Load");
//		panelNorth.add(LoadButton);
//		SaveButton = new JButton("Save");
//		panelNorth.add(SaveButton);
//		SpeedButton = new JButton("Speed: x" + speed);
//		panelNorth.add(SpeedButton);
//		PauseButton = new JButton("Pause");
//		panelNorth.add(PauseButton);
//		ResetButton = new JButton("Reset");
//		panelNorth.add(ResetButton);
//		LoadState loader = new LoadState(LoadButton, model);
//		LoadButton.addActionListener(loader);
//		SpeedState speeder = new SpeedState(SpeedButton, speed, model);
//		SpeedButton.addActionListener(speeder);
//		SaveState saver = new SaveState(SaveButton, model);
//		SaveButton.addActionListener(saver);
//		PauseState pauser = new PauseState(PauseButton, speed, model);
//		PauseButton.addActionListener(pauser);
//		ResetState resetter = new ResetState(ResetButton, model);
//		ResetButton.addActionListener(resetter);
//		
//		
//		JPanel panelCenter = new JPanel();
//		panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
//		add(panelCenter, BorderLayout.CENTER);
//		panel = new WorldPanel(model);
//		panelCenter.add(panel);
//		pp = new PopulationPanel(model.getWorldGrid());
//		ap = new AnalysisPanel(model.getWorldGrid());
//		JPanel panelBottom = new JPanel();
//		panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.LINE_AXIS));
//		panelBottom.add(pp);
//		panelBottom.add(ap);
//		panelCenter.add(panelBottom);
		
	//}
	
	public static void main(String[] args) throws InterruptedException {
		
		// THIS IS PSUEDO CODE FOR NOW
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
