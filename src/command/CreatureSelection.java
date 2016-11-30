package command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Creature;
import Model.Model;
import View.AnalysisPanel;

public class CreatureSelection extends MouseAdapter {
	private static Model model;
	private static int xPos;
	private static int yPos;
	private static Creature nearestCreature;
	private static AnalysisPanel ap;
	
	public CreatureSelection(Model model, AnalysisPanel ap){
		this.model = model;
		this.ap = ap;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.xPos = e.getX();
		this.yPos = e.getY();
		ap.repaint();
		
	}
	public static Creature nearestCreature(){
		nearestCreature = model.getNearestCreature(xPos, yPos);
		return nearestCreature;	
	}
}
