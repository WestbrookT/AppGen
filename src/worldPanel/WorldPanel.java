package worldPanel;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import tile.Tile;
import tile.WorldGrid;

public class WorldPanel extends JPanel {

    private int width = 800;
    private int height = 400;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
    private WorldGrid grid;
    

    public WorldPanel(WorldGrid wg) {
        this.grid = wg;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Tile[][] tilesGrid = grid.getTiles();
        for(int x=0;x<tilesGrid.length;x++) {
        	for(int y=0;y<tilesGrid[x].length;y++) {
        		g2.setColor(new Color(tilesGrid[x][y].getR(),tilesGrid[x][y].getG(),tilesGrid[x][y].getB()));
                g2.drawRect(x*tilesGrid.length/width, y*tilesGrid[x].length/height, 10, 10);
                /* TODO: Change size of rects, make colored worldgrid */
        	}
        }
    }

    public WorldGrid getGrid() {
        return grid;
    }

    private static void createAndShowGui() {
        WorldGrid wg = new WorldGrid(10,10);
        //wg.consume(5,5,128,128,128);
        WorldPanel mainPanel = new WorldPanel(wg);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("World Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}