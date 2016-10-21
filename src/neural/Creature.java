package neural;

import tile.WorldGrid;

public class Creature {
	
	private int size;
	private Network brain;
	private int r, g, b;
	private int xPos;
	private int yPos;
	
	private WorldGrid world;
	private double angle;
	private static final double eyeMax = 5.0;
	
	public Creature(int x, int y, WorldGrid grid) {
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
	private void check() {
		if (size <= 0) {
			world.killCreature(xPos, yPos);
		}
	}
	
	private void eat(double val) {
		int cost = (int)(size*.05)+1;
		size -= cost;
		if (val > .5)
			size += world.consume(xPos, yPos, r, g, b);
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
	private int[] look(double eyeDis) {
		
		int xd = (int)(eyeDis*Math.cos(2*Math.PI*angle));
		int yd = (int)(eyeDis*Math.sin(2*Math.PI*angle));
		return null;
		
		
	}
	
	public void act() {
		/*
		 * Inputs are the rgb values (sigmoided) of the eye, the size of the 
		 * creature through sigmoid, whether it sees and enemy, rgb values
		 * of its location.
		 */
		double[] inputs = new double[8];
		
		
		
	}
	
	public double[][] run() {
		return null;
	}
	
	private Creature reproduce() {
		return null;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	
}







