package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tile implements Serializable {
	
	private int r;
	private int g;
	private int b;
	private int maxR;
	private int maxG;
	private int maxB;
	private int lastIter = 0;
	private static int iter = 0;
	private ArrayList<Creature> creatures;
	
	public Tile(int R, int G, int B) {
		r = R;
		maxR = r;
		
		g = G;
		maxG = g;
		
		b = B;
		maxB = b;
		
		creatures = new ArrayList<Creature>();
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getMaxR() {
		return maxR;
	}

	public void setMaxR(int maxR) {
		this.maxR = maxR;
	}

	public int getMaxG() {
		return maxG;
	}

	public void setMaxG(int maxG) {
		this.maxG = maxG;
	}

	public int getMaxB() {
		return maxB;
	}

	public void setMaxB(int maxB) {
		this.maxB = maxB;
	}
	
	public void update() {
		int diff = iter - lastIter;
		diff = (int)(diff/10);
		
		r = diff + r < maxR ? diff+r : maxR;
		g = diff + g < maxG ? diff+g : maxG;
		b = diff + b < maxB ? diff+b : maxB;
		
		
		if (diff != 0)
			lastIter = iter;
	}
	public void incIter() {
		iter++;
	}
	

	public int consume(int r2, int g2, int b2) {
		double val = .1;
		int out;
		if (r2 == Math.max(r2, Math.max(g2, b2))) {
			out = (int)(r*val);
			r = (int)(r*(1-val));
		} 
		else if (g2 == Math.max(g2, b2)) {
			out = (int)(g*val);
			g = (int)(g*(1-val));
		}
		else {
			out = (int)(b*val);
			b = (int)(b*(1-val));
		}
		return out*2;
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
	
	public void addCreature(Creature c) {
		creatures.add(c);
	}
	
	public int[] look(int x, int y) {
		
		int[] out = {r, g, b, 0};
		
		for (Creature c : creatures) {
			if (c.getX() == x && c.getY() == y)
				out[3] = 1;
		}
		
		return out;
		
	}

	public int attack(int x, int y, int size) {
		
		Creature closest = null;
		double cDis = 20;
		
		for (Creature c : creatures) {
			
			double dis = Math.pow((x-c.getX()), 2) + Math.pow((y-c.getY()), 2);
			dis = Math.sqrt(dis);
			
			if (dis < cDis) {
				if (dis != 0) {
					cDis = dis;
					closest = c;
				}
			}
		}
		if (closest == null)
			return 0;
		
		int out = closest.damage(size);
		
		return out;
	}
}