package tile;

public class WorldGrid {
	
	private Tile[][] tiles;

	public int consume(int xPos, int yPos, int r, int g, int b) {
		// TODO Auto-generated method stub
		int x = (int)(xPos/10);
		int y = (int)(yPos/10);
		return tiles[x][y].consume(r, g, b);
	}

}
