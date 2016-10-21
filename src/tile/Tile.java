package tile;

import java.util.ArrayList;

import neural.Creature;

public class Tile {
	
	private int r;
	private int g;
	private int b;
	private int maxR;
	private int maxG;
	private int maxB;
	private int lastIter = 0;
	private static int iter = 0;
	private ArrayList<Creature> creatures;
	
	public int getR() {
		update();
		return r;
	}

	public void setR(int r) {
		update();
		this.r = r;
	}

	public int getG() {
		update();
		return g;
	}

	public void setG(int g) {
		update();
		this.g = g;
	}

	public int getB() {
		update();
		return b;
	}

	public void setB(int b) {
		update();
		this.b = b;
	}

	public int getMaxR() {
		update();
		return maxR;
	}

	public void setMaxR(int maxR) {
		update();
		this.maxR = maxR;
	}

	public int getMaxG() {
		update();
		return maxG;
	}

	public void setMaxG(int maxG) {
		update();
		this.maxG = maxG;
	}

	public int getMaxB() {
		update();
		return maxB;
	}

	public void setMaxB(int maxB) {
		update();
		this.maxB = maxB;
	}
	
	private void update() {
		for (int i = lastIter; i < iter; i++)
		{
			while (r < maxR)
				r++;
			while (g < maxG)
				g++;
			while (b < maxB)
				b++;
		}
		lastIter = iter;
	}
	

	public int consume(int r2, int g2, int b2) {
		// TODO Auto-generated method stub
		update();
		int out;
		if (r2 == Math.max(r2, Math.max(g2, b2))) {
			out = (int)(r*.1);
			r = (int)(r*.9);
		} 
		else if (g2 == Math.max(g2, b2)) {
			out = (int)(g*.1);
			g = (int)(g*.9);
		}
		else {
			out = (int)(b*.1);
			b = (int)(b*.9);
		}
		return out;
	}
	
	public ArrayList<Creature> getCreatures() {
		return creatures;
	}
	
	public void removeCreature(Creature c) {
		for (int i = 0; i < creatures.size(); i++) {
			if (creatures.get(i) == c) {
				creatures.remove(i);
				return;
				
			}
		}
	}
	
	public int[] look(int x, int y) {
		
	}
}











