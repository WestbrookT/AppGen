package neural;

import java.util.Arrays;

public class NetTest {

	public static void main(String[] args) {
		int[] l = {9, 1, 9};
		
		
		Network n = new Network(l);
		
		//n.print();
		
		double[] ins = {0.5882352941176471, 0.5882352941176471, 0.5882352941176471, 1.0, 0.2689414213699951, 0.5882352941176471, 0.5882352941176471, 0.5882352941176471, 0.0};
		
		System.out.println(Arrays.toString(n.out(ins)));
		System.out.println("\n\n");


		
		
		
		

	}

}
