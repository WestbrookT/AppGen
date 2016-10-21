package neural;

import java.util.Random;

import sun.nio.ch.Net;
import tile.WorldGrid;

public class Creature {
	
	private int size;
	private Network brain;
	private int r, g, b;
	private int xPos;
	private int yPos;
	
	private WorldGrid world;
	private double angle;
	private double eyeDis;
	private final double eyeMax = 5.0;
	
	private double mutationRate = .5;
	private double mutationSize = .1;
	
	public Creature(int x, int y, int size, WorldGrid grid) {
		size = 10;
		//inputs: rgbEye, mass/10, enemy(0, 1), rgbSelf 
		// eyedis1 eyeDir movedis1 movedir2 attack1 eat1 reproduce
		int[] layers = {8, 10, 8};
		brain = new Network(layers);
		r = 150;
		g = 150;
		b = 150;
		xPos = x;
		yPos = y;
		world = grid;
	}
	
	public Creature(int x, int y, int size, WorldGrid grid, double[][][] net) {
		size = 10;
		//inputs: rgbEye, mass/10, enemy(0, 1), rgbSelf 
		// eyedis1 eyeDir movedis1 movedir2 attack1 eat1 reproduce
		
		brain = new Network(net);
		r = 150;
		g = 150;
		b = 150;
		xPos = x;
		yPos = y;
		world = grid;
	}
	
	private void check() {
		if (size <= 0) {
			world.killCreature(xPos, yPos);
		}
	}
	
	private void eat(double val) {
		
		if (val > .5) {
			int cost = (int)(size*.05)+1;
			size -= cost;
			size += world.consume(xPos, yPos, r, g, b);
		}
	}
	
	private void attack(double val) {
		if (val > .5) {
			int cost =  (int)(size*.06)+1;
			size -= cost;
			size += world.attack(xPos, yPos, size);
		}
		
	}
	
	private Creature child(int startSize) {
		
		double[][][] net = brain.getNetwork();
		
		Random r = new Random();
		
		for (int layer = 0; layer < net.length; layer ++) {
			for (int neuron = 0; neuron < net[layer].length; neuron++) {
				for (int weight = 0; weight < net[layer][neuron].length; weight++) {
					if (r.nextDouble() > 1.0 - mutationRate) {
						int dir = (r.nextInt() % 2 == 0) ? 1 : -1;
						net[layer][neuron][weight] += dir*mutationSize;
					}
						
				}
			}
		}
		
		return new Creature(xPos+1, yPos+1, startSize, world, net);
	}
	
	private void reproduce(double val) {
		if (val > .7) {
			int cost = (int)(size*.1)+5;
			size -= cost;
			
			Creature kid = child(cost);
			
			world.createCreature(kid);
		}
	}
	
	
	
	private void move(double x, double y) {
		int xOld = xPos;
		int yOld = yPos;
		if (Math.abs(x) > .5) {
			xPos += Math.round(x);
			
		}
		if (Math.abs(y) > .5) {
			yPos += Math.round(y);
		}
		if (xOld != xPos || yOld != yPos)
			world.move(xOld, yOld, xPos, yPos);
		
	}
	
	private double sig(double num) {
		return 1/(1+Math.exp(-num));
	}
	
	/**
	 * 
	 * @return an array with 4 values, rgb and enemyPresent
	 */
	private int[] look(boolean delta) {
		int xd, yd;
		if (delta) {
			xd = (int)(eyeDis*eyeMax*Math.cos(2*Math.PI*angle));
			yd = (int)(eyeDis*eyeMax*Math.sin(2*Math.PI*angle));
		}
		else {
			xd = 0;
			yd = 0;
		}
		
		
		return world.look(xPos+xd, yPos+yd);
				
	}
	
	public void act() {
		/*
		 * Inputs are the rgb values (sigmoided) of the eye, the size of the 
		 * creature through sigmoid, whether it sees and enemy, rgb values
		 * of its location.
		 */
		double[] inputs = new double[8];
		int[] rgbe = look(true);
		for (int i = 0; i < rgbe.length-1; i++) {
			inputs[i] = rgbe[i]/255.0;
		}
		inputs[3] = rgbe[3];
		
		inputs[4] = sig(size/10.0);
		
		
		rgbe = look(false);
		for (int i = 0; i < rgbe.length-1; i++) {
			inputs[i+5] = rgbe[i]/255.0;
		}
		// WORK HERE NEXT TIME FINISH THINKING
		
		
		
	}
	
	public double[][][] weights() {
		return brain.getNetwork();
	}
	
	
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void mvX(int x) {
		xPos += x;
	}
	public void mvY(int y) {
		yPos += y;
	}
	
	public int damage(int s) {
		int dam = (int)(s*.1)+1;
		size -= dam;
		return dam;
	}
	
	
}







