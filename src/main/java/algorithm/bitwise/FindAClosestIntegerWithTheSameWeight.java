package algorithm.bitwise;

/**
 * Description : EPI Chapter 5.4 p50
 * Created_By : xmpy
 * Time : Jul 21, 2016 4:57:22 PM  
 */
public class FindAClosestIntegerWithTheSameWeight {

	public long closestLongSameBitCount(long x) {
		int width = Long.SIZE;
		long lsb = x & 1;
		for (int i = 1; i < width; i++) {
			if (((x >>> i) & 1) != lsb) {
				return x ^ (( 1L << i) | (1L << i - 1));
			}
		}
		// For x = 0 or x = 1
		throw new IllegalArgumentException("All bits are 0 or 1");
	}
	
}
