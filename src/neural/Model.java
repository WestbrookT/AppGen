package neural;

import java.util.ArrayList;

import tile.Tile;
import tile.WorldGrid;

public class Model {
	
	//private Creature creatures = new Creature();
	
	private static WorldGrid world;
	
	public Tile[][] getWorldState() {
		return null;
	}
	
	public Creature[][] getCreatureState() {
		return world.getArrayCreatures();
	}
	
	public void save(String filename) {
		
	}
	
	public void advance() {
		
	}
	
	public Creature getNearestCreature(int x, int y) {
		return null;
	}
	
	public ArrayList<Creature> getCreatures() {
		return world.getCreatures();
	}
	
	public void load(String filename) {
		
	}
	
	public static void main(String[] args) {
		
		
		world = new WorldGrid(3, 7, 3, 1);
		
		
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
		
		for (int x = 0; x < 100000; x++) {
			world.advance();
			if (x% 10 == 0)
				System.out.println(x);
		}
		
		for (int x = 0; x < 100; x++) {
			world.advance();
			
			
			System.out.println("\n\n\n\n\n\n\n\n");
			for (int i = 0; i < xs*ts; i++) {
				
				for (int j = 0; j < ys*ts; j++)
					if (c[i][j] != null)
						System.out.print(" X");
					else
						System.out.print(" .");
				System.out.println();
			}
			
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
