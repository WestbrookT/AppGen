package neural;

import java.util.Arrays;

public class Network {

	Layer[] layers = null;
	int[] layerSizes = null;
	
	public Network(int[] layerSizes) {
		this.layerSizes = layerSizes;
		layers = new Layer[layerSizes.length];
		
		layers[0] = new Layer(layerSizes[0], layerSizes[1]);
		
		for (int i = 1; i < layerSizes.length; i++) {
			layers[i] = new Layer(layerSizes[i-1], layerSizes[i]);
		}
		
	}
	
	public double[] out(double[] inputs) {
		
		double[] temp = inputs;
		
		for (int i = 1; i < layers.length; i++) {
			temp = layers[i].out(temp);
		}
		
		return temp;
	}
	public void print() {
		
		for (int i = 0; i < layers.length; i ++) {
			for (int j = 0; j < layers[i].neurons.length; j++) {
				System.out.print(Arrays.toString(layers[i].neurons[j].weights));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
