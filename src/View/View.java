package View;

import java.awt.*;
import javax.swing.*;

import Model.Model;

import View.AnalysisPanel;
import View.PopulationPanel;
import View.WorldPanel;

import command.CreatureSelection;
import command.LoadState;
import command.PauseState;
import command.ResetState;
import command.SaveState;
import command.SpeedState;

public class View extends JFrame{
	private JButton LoadButton;
	private JButton SpeedButton;
	private JButton SaveButton;
	private JButton PauseButton;
	private JButton ResetButton;
	
	public WorldPanel panel;
	public PopulationPanel pp;
	private AnalysisPanel ap;

	private static int speed = 1;
	
	public View(Model model){
		super("Evolutionary Neural Control Simulator");
		
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
		ResetButton = new JButton("Reset");
		panelNorth.add(ResetButton);
		
		LoadState loader = new LoadState(LoadButton, model);
		LoadButton.addActionListener(loader);
		SpeedState speeder = new SpeedState(SpeedButton, speed, model);
		SpeedButton.addActionListener(speeder);
		SaveState saver = new SaveState(SaveButton, model);
		SaveButton.addActionListener(saver);
		PauseState pauser = new PauseState(PauseButton, speed, model);
		PauseButton.addActionListener(pauser);
		
		ResetState resetter = new ResetState(ResetButton, model);
		ResetButton.addActionListener(resetter);
	
		JPanel panelCenter = new JPanel();	
		panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
		add(panelCenter, BorderLayout.CENTER);
		panel = new WorldPanel(model);
		panelCenter.add(panel);
		
		
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.LINE_AXIS));
		pp = new PopulationPanel(model.getWorldGrid());
		ap = new AnalysisPanel(model.getWorldGrid());
		panelBottom.add(pp);
		panelBottom.add(ap);
		panelCenter.add(panelBottom);
		
		panel.addMouseListener(new CreatureSelection(model, ap));
	}
}