package View;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import Model.Creature;
import Model.Model;
import Model.Tile;

public class WorldPanel extends JPanel {

    private Model model;
    private ArrayList<Creature> creatureList;
    private int tileSize;
    
    public WorldPanel(Model model) {
        this.model = model;
        creatureList = model.getWorldGrid().getCreatures();
        tileSize = model.getWorldGrid().getTileSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Tile[][] tilesGrid = model.getWorldGrid().getTiles();

        try {
            for (int y = 0; y < tilesGrid[0].length; y++) {
                for (int x = 0; x < tilesGrid.length; x++) {
                    g2.setColor(new Color(tilesGrid[x][y].getR(), tilesGrid[x][y].getG(), tilesGrid[x][y].getB()));
                    g2.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
                }
            }
        } catch (Exception e) {

        }
        try {
        	for(Creature c : model.getCreatures()) {
        		g2.setColor(new Color(c.getR(), c.getG(), c.getB()));
        		g2.fillOval(c.getX()-((int)Math.sqrt(c.getSize()))/2, c.getY()-((int)Math.sqrt(c.getSize()))/2,(int)Math.sqrt(c.getSize())+1,(int)Math.sqrt(c.getSize())+1);
        	}
        } catch(Exception E) {}
    }


}