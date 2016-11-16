package main;

import java.util.Random;

public class PerlinArray {
	
	private int width;
	private int height;
	private int size;
	private int layers;
	private int smooth;
	private Random r;
	private double thresh = .3;
	
	
	public PerlinArray(int w, int h, int s, int l, int sm) {
		
		width = w;
		height = h;
		size = s;
		layers = l;
		smooth = sm;
		r = new Random();
		
	}
	
	public double[][][] build() {
		double[][] r = map(width, height, size, layers, smooth);
		double[][] g = map(width, height, size, layers, smooth);
		double[][] b = map(width, height, size, layers, smooth);
		
		
		
		return null;
	}
	

	private double[][] map(int w, int h, int s, int l, int sm) {
		// TODO Auto-generated method stub
		double[][] m = new double[w][h];
		
		int wt = (int)(w/s);
		int ht = (int)(h/s);
		
		double[][] temp = new double[wt][ht];
		
		for (int y = 0; y < ht; y++) {
			for (int x = 0; x < wt; x++) {
				temp[x][y] = Math.pow(r.nextFloat(), 3);
			}
		}
		smooth(temp, 2);
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				m[x][y] = temp[(int)(x/s)][(int)(y/s)];
			}
		}
		
		add(m, map(w, h, (int)(s/2), l-1, sm));
		
		
		return m;
		
	}
	
	private void add(double[][] ori, double[][] temp) {
		
		int w = ori.length;
		int h = ori[0].length;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				ori[x][y] += temp[x][y];
				if (ori[x][y] > 1)
					ori[x][y] = 1.0;
			}
		}
	}
	
	private void smooth(double[][] arr, int sm) {
		
		int w = arr.length;
		int h = arr[0].length;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				
				int[][] locs = {{x, y+1}, {x+1, y}, {x, y-1}, {x-1, y+1}
							, {x+1, y-1}, {x+1, y+1}, {x-1, y+1}, {x-1, y-1}};
				
				
				double temp = arr[x][y];
				
				for (int[] c : locs) {
					if (c[0] < w && c[0] >= 0 && c[1] < h && c[1] >= 0) {
						temp += arr[c[0]][c[1]];
					}
					else
						temp += arr[x][y];
				}
				arr[x][y] = temp/9;
				
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
