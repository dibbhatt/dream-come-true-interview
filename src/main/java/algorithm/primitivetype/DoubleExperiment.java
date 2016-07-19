package algorithm.primitivetype;

public class DoubleExperiment {
	public static void main (String[] args) {
		double a = 1.000001;
	    double b = 0.000001;
		System.out.println(Double.compare(1.0, a - b));
	}
}
