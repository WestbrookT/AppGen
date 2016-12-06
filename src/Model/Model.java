package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {
	
	private static WorldGrid world;
	private int speed = 1;
	private boolean paused = false;
	
	private int xT;
	private int yT;
	private int tS;
	private int c;
	
	private int width;
	private int height;
	private int ms;
	private int layers;
	private static Creature nearestCreature;
	
	
	public Model(int xTileCount, int yTileCount, int tSize, int c) {
		world = new WorldGrid(xTileCount, yTileCount, tSize, c);
		xT = xTileCount;
		yT = yTileCount;
		tS = tSize;
		this.c = c;
	}
	
	public void reset() {
		
		PerlinArray pa = new PerlinArray(width, height, ms, layers, ms);
		double[][][] map = pa.build();
		pa.thresh(4, .3);
			
		world = new WorldGrid(map, tS, c);
	}
	
	public Model(int w, int h, int s, int l, int sm, int tileSize, int c) {
		PerlinArray pa = new PerlinArray(w, h, s, l, s);
		double[][][] map = pa.build();
		pa.thresh(4, .3);
		
		width = w;
		height = h;
		ms = s;
		layers = l;
		tS = tileSize;
		this.c = c;

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
	
	public void setNearestCreature(int x, int y) {
		ArrayList<Creature> creatures = world.getCreatures();
		nearestCreature = creatures.get(0);
		try {
			for(Creature creature : creatures){
				if((Math.abs(creature.getX()-x) + Math.abs(creature.getY()-y)) < (Math.abs(nearestCreature.getX()-x)+Math.abs(nearestCreature.getY()-y))){
					nearestCreature = creature;
				}
			}
		} catch(Exception e){}
	}
	
	public static Creature getNearestCreature() {
		
		return nearestCreature;
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
		Model.world = null;
		Model.world = loaded;
	}
	
	public void setWorld(WorldGrid w) {
		world = w;
	}
}