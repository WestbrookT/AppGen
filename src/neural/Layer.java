package neural;

public class Layer {

	Neuron[] neurons = null;
	int size;
	int lastSize;
	public Layer(int lastCount, int size) {
		neurons = new Neuron[size];
		this.size = size;
		lastSize = lastCount;
		
		for (int i = 0; i < size; i++) {
			neurons[i] = new Neuron(lastCount);
		}
		
	}
	
	public double[] out(double[] inputs) {
		double[] outs = new double[size];
		
		for (int i = 0; i < size; i++) {
			outs[i] = neurons[i].out(inputs);
		}
		return outs;
	}
	
	public double[][] getWeights() {
		double[][] outs = new double[size][lastSize];
		
		for (int i = 0; i < size; i++) {
			outs[i] = neurons[i].getWeights();
		}
		
		return outs;
	}
}
