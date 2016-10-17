package neural;

import java.util.Arrays;

public class NetTest {

	public static void main(String[] args) {
		int[] l = {2, 3, 1};
		
		
		Network n = new Network(l);
		
		n.print();
		
		double[] ins = {1.0, 1.0};
		
		System.out.println(Arrays.toString(n.out(ins)));
		System.out.println("\n\n");


		for (double[][] layer : n.getNetwork()) {
			
			for (double[] neuron : layer) {
				
				for (double weight : neuron) {
					System.out.printf("%.1f ", weight);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		Network n1 = new Network(n.getNetwork());
		
		for (double[][] layer : n1.getNetwork()) {
					
			for (double[] neuron : layer) {
				
				for (double weight : neuron) {
					System.out.printf("%.1f ", weight);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}
