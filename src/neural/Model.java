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
			for (int i = 0; i < 100000; i++)
				for (int j = 0; j < 20000; j++)
					for (int k = 0; k < 1; k++)
					{
						int b = i + j;
					}
	
			
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
