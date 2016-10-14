package neural;

import java.util.Arrays;

public class NetTest {

	public static void main(String[] args) {
		int[] l = {2, 30, 4};
		
		
		Network n = new Network(l);
		
		n.print();
		
		double[] ins = {1.0, 1.0};
		
		System.out.println(Arrays.toString(n.out(ins)));

	}

}
