package AnalysisPanel;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class AnalysisPanel extends JPanel{
	private double [][][] network;
	private int height = 800;
	private int width = 800;
	private int diameter = 50;
	
    

	AnalysisPanel(double [][][] network) {
		this.network = network;
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        int i = 0;
        for (i = 0; i < network.length; i++) {
        	g2.setColor(Color.BLACK);
        	
        	for (int p = 1; p < network[i].length+1; p++) {
        		if (i<network.length-1){
        			for (int j = 0; j < network[i][p-1].length; j++) {
        				if (network[i][p-1][j] != 0){
        					System.out.println(network[i][p-1][j]);
        					float weight = (float) (1/(1+Math.exp(-(Math.abs(network[i][p-1][j])))))*5;
        					System.out.println(weight);
        					g2.setStroke(new BasicStroke(weight));
        					if (network[i][p-1][j] < 0){
        						g2.setColor(Color.RED);
        					} else {
        						g2.setColor(Color.BLACK);
        					}
            				g2.drawLine(200*(i+1)+25,(p*getHeight()/(network[i].length + 1)),200*(i+2)+25,((j+1)*getHeight()/(network[i][p-1].length + 1)));
        				}
        			}
        		}
        		g2.fillOval(200*(i+1), (p * getHeight()/(network[i].length + 1))-25, diameter, diameter);
        	}
        }
	}
	
	private static void createAndShowGui() {
        double [][][] network = {{{.1,1300000000},{-2500000,.03},{0,190000}},{{1,6}, {-2, 2}}, {{3.7, 1700.2}, {12.3, 5.9}}};
        
        AnalysisPanel mainPanel = new AnalysisPanel(network);
        mainPanel.setPreferredSize(new Dimension(800, 700));
        JFrame frame = new JFrame("Neural Network");
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