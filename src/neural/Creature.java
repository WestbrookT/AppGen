package neural;

import tile.WorldGrid;

public class Creature {
	
	private int size;
	private Network brain;
	private int r, g, b;
	private int xPos;
	private int yPos;
	private WorldGrid world;
	
	private void eat(double val) {
		int cost = (int)(size*.05)+1;
		size -= cost;
		if (val > .5)
			size += world.consume(xPos, yPos, r, g, b);
	}
	
	
	
	private void move(double x, double y) {
		if (Math.abs(x) > .5)
			xPos += Math.round(x);
		if (Math.abs(y) > .5)
			yPos += Math.round(y);
	}
	
	public void act() {
		
	}
	
	public double[][] run() {
		return null;
	}
	
	private Creature reproduce() {
		return null;
	}
	
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
}







