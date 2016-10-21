package tile;

import java.util.ArrayList;

import neural.Creature;

public class WorldGrid {
	
	private Tile[][] tiles;
	private Creature[][] creatures;
	private final int tileSize = 10;
	
	
	public WorldGrid(int xTileCount, int yTileCount) {
		tiles = new Tile[xTileCount][yTileCount];
		creatures = new Creature[xTileCount*10][yTileCount*10];
		
	}

	public int consume(int xPos, int yPos, int r, int g, int b) {
		// TODO Auto-generated method stub
		int x = (int)(xPos/10);
		int y = (int)(yPos/10);
		return tiles[x][y].consume(r, g, b);
	}

	public void killCreature(int xPos, int yPos) {
		// TODO Auto-generated method stub
		
	}

	public void move(int xOld, int yOld, int xPos, int yPos) {
		
		if (creatures[xPos][yPos] == null) {
			creatures[xPos][yPos] = creatures[xOld][yOld];
			if ((int)(xOld/tileSize) != (int)(xPos/tileSize))
		}
		
	}
	
	public int[] look(int x, int y) {
		
		int xTile = (int)(x/tileSize);
		int yTile = (int)(y/tileSize);
		
		
		
		return null;
		
		
		
	}

}
