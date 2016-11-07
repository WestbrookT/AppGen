package tile;

import java.util.ArrayList;
import java.util.Random;

import neural.Creature;

public class WorldGrid {
	
	private Tile[][] tiles;
	public Creature[][] creatures;
	private int tileSize;
	private ArrayList<Creature> cList;
	private int cCount;
	private int cStartSize = 50;
	
	private int xTiles;
	private int yTiles;
	
	
	public WorldGrid(int xTileCount, int yTileCount, int tSize, int c) {
		tiles = new Tile[xTileCount][yTileCount];
		creatures = new Creature[xTileCount*10][yTileCount*10];
		Random r = new Random();
		cList = new ArrayList<Creature>();
		cCount = c;
		tileSize = tSize;
		
		xTiles = xTileCount;
		yTiles = yTileCount;
		
		for (int y = 0; y < yTileCount; y++)
			for (int x = 0; x < xTileCount; x++) {
				tiles[x][y] = new Tile(150, 150, 150);
			}
		
		
		for (int i = 0; i < c; i++) {
			int x;
			int y;
			do {
				x = r.nextInt(xTileCount*tileSize);
				y = r.nextInt(yTileCount*tileSize);
			} while (creatures[x][y] != null);
			creatures[x][y] = new Creature(x, y, cStartSize, this);
			cList.add(creatures[x][y]);
			
			int tX = (int)(x/tileSize);
			int tY = (int)(y/tileSize);
			tiles[tX][tY].addCreature(creatures[x][y]);
		}
		
		
		
	}
	
	public WorldGrid(int xTileCount, int yTileCount, int tileSize, ArrayList<Creature> c) {
		
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
		cList.remove(c);
		//System.out.println("Killed.");
		
	}

	public int[] move(int xOld, int yOld, int xPos, int yPos) {
		Creature c = creatures[xOld][yOld];
		
		if (xPos < 0 || xPos >= xTiles)
			xPos = xOld;
		if (yPos < 0 || yPos >= yTiles)
			yPos = yOld;
		
		if (xPos == xOld && yPos == yOld) {
			int[] temp = new int[2];
			temp[0] = xPos;
			temp[1] = yPos;
			return temp;
		}
		
		
		if (creatures[xPos][yPos] == null) {
			int xOldTile = (int)(xOld/tileSize);
			int yOldTile = (int)(yOld/tileSize);
			
			int xNewTile = (int)(xPos/tileSize);
			int yNewTile = (int)(yPos/tileSize);
			
			
			boolean xChg = xOldTile != xNewTile;
			boolean yChg = yOldTile != yNewTile;
			if (xChg || yChg) {
				//System.out.println("test");
				
				tiles[xOldTile][yOldTile].removeCreature(c);
				tiles[xNewTile][yNewTile].addCreature(c);
			}
			creatures[xPos][yPos] = creatures[xOld][yOld];
			creatures[xOld][yOld] = null;
			int[] temp = new int[2];
			temp[0] = xPos;
			temp[1] = yPos;
			return temp;
		}
		int[] temp = new int[2];
		temp[0] = xOld;
		temp[1] = yOld;
		return temp;
		
		
	}
	
	public int[] look(int x, int y) {
		
		int xTile = (int)(x/tileSize);
		int yTile = (int)(y/tileSize);
		
		
		
		return tiles[xTile][yTile].look(x, y);
		
		
		
	}

	public int attack(int x, int y, int size) {
		int xTile = (int)(x/tileSize);
		int yTile = (int)(y/tileSize);
		return tiles[xTile][yTile].attack(x, y, size);
		
		
	}
	
	public ArrayList<Creature> getCreatures() {
		
		
		return cList;
		
		
	}
	
	public Creature[][] getArrayCreatures() {
		return creatures;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void createCreature(Creature kid) {
		Random r = new Random();
		while (kid.getX() >= xTiles*tileSize)
			kid.mvX(-1);
		while (kid.getX() < 0)
			kid.mvX(1);
		
		while (kid.getY() >= yTiles*tileSize)
			kid.mvY(-1);
		while (kid.getY() < 0)
			kid.mvY(1);
		
		while (creatures[kid.getX()][kid.getY()] != null) {
			int x = (r.nextInt() % 2) == 0 ? 1 : -1;
			int y = (r.nextInt() % 2) == 0 ? 1 : -1;
			
			//System.out.println("" + kid.getX() + " " + kid.getY());
			//System.out.println(creatures[kid.getX()][kid.getY()]);
			
			if (kid.getX()+x < xTiles*tileSize && kid.getX()+y >= 0)
				kid.mvX(x);
			if (kid.getY()+y < xTiles*tileSize && kid.getY()+y >= 0)
				kid.mvY(y);
			
			while (kid.getX() >= xTiles*tileSize)
				kid.mvX(-1);
			while (kid.getX() < 0)
				kid.mvX(1);
			
			while (kid.getY() >= yTiles*tileSize)
				kid.mvY(-1);
			while (kid.getY() < 0)
				kid.mvY(1);
		}
		
		creatures[kid.getX()][kid.getY()] = kid;
		cList.add(kid);
		int xTile = (int)(kid.getX()/tileSize);
		int yTile = (int)(kid.getY()/tileSize);
		
		tiles[xTile][yTile].addCreature(kid);
			
		
	}
	
	public void advance() {
		Random r = new Random();
		while (cList.size() < cCount) {
			int x = r.nextInt(xTiles*tileSize);
			int y = r.nextInt(yTiles*tileSize);
			Creature kid = new Creature(x, y, 100, this);
			createCreature(kid);
			//System.out.println(cCount);
		}
		
		
		for (int i = 0; i < cList.size(); i++) {
			cList.get(i).act();
		}
	}

	public int getXTiles() {
		// TODO Auto-generated method stub
		return xTiles;
	}

	public int getYTiles() {
		// TODO Auto-generated method stub
		return yTiles;
	}
	
	public int getTileSize() {
		
		return tileSize;
	}

	public void load(ArrayList<Creature> loaded) {
		// TODO Auto-generated method stub
		
	}
	
}
