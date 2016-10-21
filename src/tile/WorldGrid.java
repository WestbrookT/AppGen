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
		Creature c = creatures[xPos][yPos];
		creatures[xPos][yPos] = null;
		
		int xTile = (int)(xPos/tileSize);
		int yTile = (int)(yPos/tileSize);
		
		tiles[xTile][yTile].removeCreature(c);
		
	}

	public void move(int xOld, int yOld, int xPos, int yPos) {
		Creature c = creatures[xOld][yOld];
		if (creatures[xPos][yPos] == null) {
			int xOldTile = (int)(xOld/tileSize);
			int yOldTile = (int)(yOld/tileSize);
			
			int xNewTile = (int)(xPos/tileSize);
			int yNewTile = (int)(yPos/tileSize);
			
			
			boolean xChg = xOldTile != xNewTile;
			boolean yChg = yOldTile != yNewTile;
			if (xChg || yChg) {
				
				tiles[xOldTile][yOldTile].removeCreature(c);
				tiles[xNewTile][yNewTile].addCreature(c);
			}
			creatures[xPos][yPos] = creatures[xOld][yOld];
		}
		
	}
	
	public int[] look(int x, int y) {
		
		int xTile = (int)(x/tileSize);
		int yTile = (int)(y/tileSize);
		
		
		
		return tiles[xTile][yTile].look(x, y);
		
		
		
	}

	public int attack(int x, int y) {
		int xTile = (int)(x/tileSize);
		int yTile = (int)(y/tileSize);
		return tiles[xTile][yTile].attack(x, y);
		
		
	}
	
	public ArrayList<Creature> getCreatures() {
		
		ArrayList<Creature> out = new ArrayList<Creature>();
		for (int i = 0; i < creatures.length; i++)
			for (int j = 0; j < creatures[i].length; j++)
				if (creatures[i][j] != null)
					out.add(creatures[i][j]);
		return out;
		
		
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

}
