import java.lang.Math;

public class UniformDistribution implements IProbabilityDistribution {

	private double probabilityOfTrue;
	
	public UniformDistribution(double probabilityOfTrue) {
		this.probabilityOfTrue = probabilityOfTrue;
	}
	@Override
	public boolean GetBoolean(int time) {
		return Math.random() < this.probabilityOfTrue;
	}

}
