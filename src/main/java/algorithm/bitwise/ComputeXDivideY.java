package algorithm.bitwise;

public class ComputeXDivideY {
	public long divide(long x, long y) {
		final int width = 32;
		long r = 0;
		for (int i = width - 1; i >= 0; i--) {
			long currx = x >>> i;
			if ( currx >= y ) {
				r |= 1L << i;
				x -= y << i;
			}
		}  
		
		return r; 
	}
}
