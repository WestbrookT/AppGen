package View;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import Model.Creature;
import Model.Tile;
import Model.WorldGrid;

public class WorldPanel extends JPanel {

    private WorldGrid grid;
    private ArrayList<Creature> creatureList;
    private int tileSize;
    
    public WorldPanel(WorldGrid wg) {
        grid = wg;
        creatureList = grid.getCreatures();
        tileSize = grid.getTileSize();
        System.out.println(tileSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Tile[][] tilesGrid = grid.getTiles();
        for(int y=0;y<tilesGrid[0].length;y++) {
        	for(int x=0;x<tilesGrid.length;x++) {
        		g2.setColor(new Color(tilesGrid[x][y].getR(),tilesGrid[x][y].getG(),tilesGrid[x][y].getB()));
                g2.fillRect(x*tileSize, y*tileSize, tileSize, tileSize);
        	}
        }
        for(Creature c : creatureList) {
        	g2.setColor(Color.BLACK);
        	g2.fillOval(c.getX(), c.getY(),3,3);
        }
    }

    public WorldGrid getGrid() {
        return grid;
    }
}