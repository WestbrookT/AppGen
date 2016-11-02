package neural;

import java.util.Arrays;
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
	private double memory = 0.0;
	
	private double mutationRate = .5;
	private double mutationSize = .1;
	
	public Creature(int x, int y, int size, WorldGrid grid) {
		size = 100;
		//inputs: rgbEye, mass/10, enemy(0, 1), rgbSelf 
		// eyedis1 eyeDir movedis1 movedir2 attack1 eat1 reproduce
		int[] layers = {9, 20, 10};
		brain = new Network(layers);
		r = 150;
		g = 150;
		b = 150;
		xPos = x;
		yPos = y;
		world = grid;
		this.size = size;
	}
	
	public Creature(int x, int y, int size, WorldGrid grid, double[][][] net) {
		size = 100;
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
			//System.out.println(size);
		}
	}
	
	private void eat(double val) {
		check();
		int cost = (int)(size*.05)+1;
		size -= cost;
		if (val > .5) {
			
			size += world.consume(xPos, yPos, r, g, b);
		}
	}
	
	private void attack(double val) {
		check();
		int cost =  (int)(size*.06)+1;
		size -= cost;
		if (val > .5) {
			
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
		check();
		if (val > .7) {
			//System.out.println("Kid made.");
			int cost = (int)(size*.1)+5;
			size -= cost;
			
			Creature kid = child(cost);
			
			world.createCreature(kid);
		}
	}
	
	
	
	private void move(double x, double y) {
		check();
		
		
		
		int xOld = xPos;
		int yOld = yPos;
		if (Math.abs(x) > .5) {
			xPos += (int)Math.round(x);
			
		}
		if (Math.abs(y) > .5) {
			yPos += (int)Math.round(y);
		}
		int[] temp = world.move(xOld, yOld, xPos, yPos);
		xPos = temp[0];
		yPos = temp[1];
		
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
		
		// Get all the inputs set up.
		size -= 1;
		
		double[] inputs = new double[9];
		int[] rgbe = look(true);
		for (int i = 0; i < rgbe.length-1; i++) {
			inputs[i] = rgbe[i]/255.0;
		}
		inputs[3] = rgbe[3];
		
		inputs[4] = sig(size);
		
		
		rgbe = look(false);
		for (int i = 0; i < rgbe.length-1; i++) {
			inputs[i+5] = rgbe[i]/255.0;
		}
		
		inputs[8] = memory;
		
		double[] decisions = brain.out(inputs);
		if (decisions.length < 1) {
			
			for (int i = 0; i < 9; i++)
				System.out.print(inputs[i] + " ");
			System.out.println();
			System.out.println(Arrays.toString(brain.out(inputs)));
			
			System.out.println(decisions.length);
			brain.print();
			//while (true);
			System.exit(1);
		}
		
		/*
		 * This is the part where the network makes decisions.
		 */
		
		move(decisions[0], decisions[1]);
		angle = decisions[2];
		attack(decisions[3]);
		reproduce(decisions[4]);
		eat(decisions[9]);
		
		
		//Change the color of the creature to match its decisions.
		
		r = (int)(255*((1+decisions[5])/2));
		g = (int)(255*((1+decisions[6])/2));
		b = (int)(255*((1+decisions[7])/2));
		
		// Update the memory variable
		memory = decisions[8];
		
		
		
		
		
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

	public int getR() {
		// TODO Auto-generated method stub
		//System.out.println(r);
		return r;
	}
	
	
}







