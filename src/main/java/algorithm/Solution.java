package algorithm;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Sep 19, 2015 
 * Time : 12:03:19 PM
 */
class Logistic {
    private double rate = 0.01;
    private double lam = 0;
    private int d = 0;
    private double[] weights;
    private int ITERATIONS = 10000;

    public Logistic(int d, float lam) {
    	this.lam = lam;
    	this.d = d + 1;
        weights = new double[d + 1]; // last is b
    }
    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }
    
    public double[] getWeights() {
		return weights;
	}

	private float getNum(float[] x, int idx, int j) {
    	if (j == d - 1) {
    		return 1;
    	} else {
    		return x[idx * (d - 1) + j];
    	}
    }
    
    
    private double classify(float[] x, int idx) {
    	float logit = .0f;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * getNum(x, idx, i);
        }
        return sigmoid(logit);
    }
    
    public void train(int n, float[] x, int[] y ) {
        for (int iterI = 0; iterI < ITERATIONS; iterI++) {
            double lik = 0.0;
            for (int i = 0; i < n; i++) {
            	int baseIdx = i * d;
            	double predicted = classify(x, i);
                int label = y[i];
                for (int j=0; j < weights.length; j++) {
                    weights[j] = weights[j] - rate * ((predicted - label) * getNum(x, i, j) - lam * weights[j]);
                }
                lik += label * Math.log(classify(x, i)) + (1-label) * Math.log(1- classify(x, i));
            }
        }
    }   
}


public class Solution {
		
	public float[] train_logistic_regression(int n, int d, float[] x, int[] y, float lam, float[] wb) {
		Logistic log = new Logistic(d, lam);
		log.train(n, x, y);
		double[] w = log.getWeights();
		float[] result = new float[w.length];
		for (int i = 0; i < w.length; i++) {
			result[i] = (int)(1000.0f * w[i]) / 1000.0f;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		float[] r;
		r = (s.train_logistic_regression(2, 2, new float[] {1,2,3,4}, new int[] {1,1},0.02f ,null ));
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}

	}

}