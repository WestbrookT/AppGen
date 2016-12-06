package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import Model.Creature;
import Model.Model;
import Model.WorldGrid;
import command.CreatureSelection;
import main.Main;

public class AnalysisPanel extends JPanel {
	private double[][][] network;
	private ArrayList<Creature> currentPop;
	private Creature nearestCreature;
	private Model model;

	public AnalysisPanel(Model model) {
		this.model = model;
		currentPop = model.getWorldGrid().getCreatures();
		this.nearestCreature = model.getNearestCreature();
		
		if(nearestCreature == null){
			network = currentPop.get(0).weights();
		}
		else{
			network = nearestCreature.weights();
		}
		
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        nearestCreature = model.getNearestCreature();
        if(nearestCreature != null){
        	network = nearestCreature.weights();
        }
        
        int i = 0;
        for (i = 0; i < network.length; i++) {
        	g2.setColor(Color.BLACK);
        	for (int p = 1; p < network[i].length+1; p++) {
        		if (i<network.length-1){
        			for (int j = 0; j < network[i][p-1].length; j++) {
        				if (network[i][p-1][j] != 0){
        					float weight = ((float) (1/(1+Math.exp(-(Math.abs(network[i][p-1][j]))))))*1;					
        					g2.setStroke(new BasicStroke(weight));
        					if (network[i][p-1][j] < 0){
								g2.setColor(new Color(255, Math.min(255, Math.abs((int)(255*weight))), Math.min(255, Math.abs((int)(255*weight)))));
        					} else {
        						g2.setColor(new Color(Math.min(255, (int)(255*Math.abs(weight))), Math.min(255, Math.abs((int)(255*weight))), Math.min(255, Math.abs((int)(255*weight)))));
        					}
            				g2.drawLine((getWidth()/(network.length+1))*(i+1)+(getHeight()/16)/2,(p*getHeight()/(network[i].length + 1)),(getWidth()/(network.length+1))*(i+2)+(getHeight()/16)/2,((j+1)*getHeight()/(network[i][p-1].length + 1)));
        				}
        			}
        		}
        		g2.setColor(Color.BLACK);
        		g2.fillOval((getWidth()/(network.length+1))*(i+1), (p * getHeight()/(network[i].length + 1))-(getHeight()/16)/2, (getHeight()/16), getHeight()/16);
        	}
        }
	}
}