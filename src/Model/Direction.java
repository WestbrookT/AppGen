package Model;

public class Direction {
	
	public static int[] delta(double angle, double direct) {
		
		angle = (angle + 1)/2.0;
		int[] out = new int[2];
		
		if (Math.abs(direct) < .3)
			return out;
		
	
		
		if (direct < 0) {
			angle = 1.0 - angle;
		}
		
		
		
		if (angle < .0625) {
			out[0] = 1;
		} else if (angle < .1875) {
			out[0] = 1;
			out[1] = -1;
		} else if (angle < .3125) {
			out[1] = -1;
		} else if (angle < .4375) {
			out[0] = -1;
			out[1] = -1;
		} else if (angle < .5625) {
			out[0] = -1;
		} else if (angle < .6875) {
			out[0] = -1;
			out[1] = 1;
		} else if (angle < .8125) {
			out[1] = 1;
		} else if (angle < .9375) {
			out[0] = 1;
			out[1] = 1;
		} else {
			out[0] = 1;
		}
		
		
		
		return out;
	}

}
