package Model;

import java.util.ArrayList;

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
		//update();
		return r;
	}

	public void setR(int r) {
		//update();
		this.r = r;
	}

	public int getG() {
		//update();
		return g;
	}

	public void setG(int g) {
		//update();
		this.g = g;
	}

	public int getB() {
		//update();
		return b;
	}

	public void setB(int b) {
		//update();
		this.b = b;
	}

	public int getMaxR() {
		//update();
		return maxR;
	}

	public void setMaxR(int maxR) {
		//update();
		this.maxR = maxR;
	}

	public int getMaxG() {
		//update();
		return maxG;
	}

	public void setMaxG(int maxG) {
		//update();
		this.maxG = maxG;
	}

	public int getMaxB() {
		//update();
		return maxB;
	}

	public void setMaxB(int maxB) {
		//update();
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
		// TODO Auto-generated method stub
		//update();
		double val = .3;
		int out;
		if (r2 == Math.max(r2, Math.max(g2, b2))) {
			out = (int)(r*val);
			r = (int)(r*1-val);
		} 
		else if (g2 == Math.max(g2, b2)) {
			out = (int)(g*val);
			g = (int)(g*1-val);
		}
		else {
			out = (int)(b*val);
			b = (int)(b*1-val);
		}
		return out/2;
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
		
		// TODO Auto-generated method stub
		return out;
	}
}