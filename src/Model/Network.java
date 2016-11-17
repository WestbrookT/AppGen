package Model;

import java.util.Arrays;

public class Network {

	private Layer[] layers = null;
	private int[] layerSizes;
	
	public Network(int[] layerSizes) {
		this.layerSizes = layerSizes;
		layers = new Layer[layerSizes.length];
		
		layers[0] = new Layer(layerSizes[0], layerSizes[1]);
		
		for (int i = 1; i < layerSizes.length; i++) {
			layers[i] = new Layer(layerSizes[i-1], layerSizes[i]);
		}
		
	}
	
	public double[] out(double[] inputs) {
		//System.out.println("--");
		//System.out.println(Arrays.toString(inputs));
		
		double[] temp = new double[inputs.length];
		for (int i = 0; i < temp.length; i++)
			temp[i] = inputs[i];
		
		//System.out.println("Before" + Arrays.toString(temp));
		for (int i = 1; i < layers.length; i++) {
			temp = layers[i].out(temp);
			//System.out.print("here " + i);
			//System.out.println(Arrays.toString(temp));
			
		}
		if (temp.length < 1) {
			//System.out.println(Arrays.toString(inputs));
			System.out.println(Arrays.toString(temp));
			System.out.println("---");
		}
		return temp;
	}
	public void print() {
		
		for (int i = 0; i < layers.length; i ++) {
			for (int j = 0; j < layers[i].neurons.length; j++) {
				System.out.print(Arrays.toString(layers[i].getNeurons()[j].getWeights()));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public double[][][] getNetwork() {
		double[][][] net = new double[layers.length][][];
		
		for (int i = 0; i < layers.length; i++) {
			net[i] = layers[i].getLayer();
		}
		return net;
	}
	
	public Network(double[][][] net) {
		
		layers = new Layer[net.length];
		layerSizes = new int[net.length];
		
		for (int i = 0; i < net.length; i++) {
			layers[i] = new Layer(net[i]);
			layerSizes[i] = net[i].length;
			
		}
	}
	
	
}
