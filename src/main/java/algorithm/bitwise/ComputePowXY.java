package algorithm.bitwise;

public class ComputePowXY {
	
	public double power(double x, int y) {
		boolean sign = false;
		if ( y < 0 ) {
			y = -y;
			sign = true;
		}
		double r = 1;
		for (int i = 0; i < Integer.SIZE - 1; i++) {
			if ((( y >>> i ) & 1 ) != 0) {
				r *= x;
			}
			x = x * x;
		}
		if (sign) {
			r = 1 / r;
		}
		return r;
	}
	
}
