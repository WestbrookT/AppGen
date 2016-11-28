package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Model {
	
	//private Creature creatures = new Creature();
	
	private static WorldGrid world;
	private int speed = 1;
	private boolean paused = false;
	
	public Model(int xTileCount, int yTileCount, int tSize, int c) {
		world = new WorldGrid(xTileCount, yTileCount, tSize, c);
	}
	
	public Model(int w, int h, int s, int l, int sm, int tileSize, int c) {
		PerlinArray pa = new PerlinArray(w, h, s, l, s);
		double[][][] map = pa.build();
		pa.thresh(4, .31);

		
		world = new WorldGrid(map, tileSize, c);
	}

	public void setSpeed(int i) {
		speed = i;
	}

	public boolean pause() {
		paused = !paused;
		return paused;
	}
	
	public Tile[][] getWorldState() {
		return world.getTiles();
	}
	
	public WorldGrid getWorldGrid() {
		return world;
	}
	
	public Creature[][] getCreatureState() {
		return world.getArrayCreatures();
	}
	
	public void save(String filename) {
		try {
			FileOutputStream wOut = new FileOutputStream(filename);
			ObjectOutputStream worldOut = new ObjectOutputStream(wOut);
			worldOut.writeObject(world);
			worldOut.close();
			wOut.close();
		} catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void advance() {
		if (paused) return;

		for (int i = 0; i < speed; i++)
			world.advance();
		
	}
	
	public Creature getNearestCreature(int x, int y) {
		return null;
	}
	
	public ArrayList<Creature> getCreatures() {
		return world.getCreatures();
	}
	
	public void load(String filename) {
		WorldGrid loaded = null;
		try {
			FileInputStream wIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(wIn);
			loaded = (WorldGrid) in.readObject();
		} catch (EOFException z) {
			System.out.println("end of file");
		} catch (IOException j) {
			j.printStackTrace();
			return;
		} catch (ClassNotFoundException y) {
			System.out.println("class not found");
			y.printStackTrace();
			return;
		} 
		world = loaded;
	}
	
	public static void main(String[] args) {
		
		
		world = new WorldGrid(10, 20, 2, 10);
		
		
		Creature[][] c = world.getArrayCreatures();
		
		
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++)
				if (c[i][j] != null)
					System.out.print(" X");
				else
					System.out.print(" .");
			System.out.println();
		}
		
		
		int ts = world.getTileSize();
		int xs = world.getXTiles();
		int ys = world.getYTiles();
		
		for (int x = 0; x < 1000000; x++) {
			world.advance();
			if (x% 1000 == 0)
				System.out.println(x);
		}
		
		for (int x = 0; x < 1000; x++) {
			world.advance();
			
			
			System.out.println("\n\n\n\n\n\n\n\n");
			for (int i = 0; i < xs*ts; i++) {
				
				for (int j = 0; j < ys*ts; j++)
					if (c[i][j] != null)
						System.out.print(" " + (int)(c[i][j].getR()/255.0*10));
					else
						System.out.print(" .");
				System.out.println();
			}
			System.out.println(x);
			for (int i = 0; i < 100000; i=i)
				for (int j = 0; j < 20000; j++)
					for (int k = 0; k < 1; k++)
					{
						int b = i + j;
					}
	
			
		}		
	}

	
	
	
	
	
	
	
	
	
}
