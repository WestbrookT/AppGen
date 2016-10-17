package neural;

import java.util.Random;

public class Neuron {
	
	double [] weights = null;
	int wCount;
	
	public Neuron(int weightCount) {
		weights = new double[weightCount];
		wCount = weightCount;
		
		Random r = new Random();
		
		for (int i = 0; i < weightCount; i++)
		{
			weights[i] = r.nextFloat() * 2 - 1;
		}
	}
	
	public Neuron(double[] ds) {
		weights = (double[])ds.clone();
	}

	public double out(double[] inputs) {
		
		
		double out = 0;
		for (int i = 0; i < inputs.length; i++) {
			out += inputs[i] * weights[i];
		}
		
		return Math.tanh(out);
		
		
	}
	
	public double[] getWeights() {
		return (double[])weights.clone();
	}

	

	

}
