package neural;

public class Layer {

	Neuron[] neurons = null;
	int size;
	
	public Layer(int lastCount, int size) {
		neurons = new Neuron[size];
		this.size = size;
		
		
		for (int i = 0; i < size; i++) {
			neurons[i] = new Neuron(lastCount);
		}
		
	}
	
	public Layer(double[][] ds) {
		neurons = new Neuron[ds.length];
		
		for (int i = 0; i < ds.length; i++) {
			neurons[i] = new Neuron(ds[i]);
		}
		
	}

	public double[] out(double[] inputs) {
		double[] outs = new double[size];
		
		for (int i = 0; i < size; i++) {
			outs[i] = neurons[i].out(inputs);
		}
		return outs;
	}
	
	
	/**
	 * Gets a copy of the layer as a double[][]
	 * @return Returns an array of double[] each of which contains a neurons set of weights.
	 */
	public double[][] getLayer() {
		
		double[][] layer = new double[neurons.length][];
		
		for (int i = 0; i < neurons.length; i++) {
			layer[i] = neurons[i].getWeights();
		}
		return layer;
	}
	
	public Neuron[] getNeurons() {
		return neurons;
	}
}
