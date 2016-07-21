package algorithm.bitwise;

/**
 * Description : EPI Chapter 5.5 p51
 * Source : 
 * Created_By : xmpy
 * Time : Jul 21, 2016 10:58:45 PM  
 */
public class ComputeXMultiplyY {

	public long multiply(long x, long y) {
		int width = Long.SIZE;
		long r = 0;
		for (int i = 0; i < width; i++) {
			if (((x >>> i) & 1) != 0) {
				r = sum(r, y << i);
			}
		}
		return r;
	}
	
	public long sum(long x, long y) {
		short carry = 0;
		long r = 0;
		for (int i = 0; i < Long.SIZE; i++) {
			long xlsb = (x >>> i) & 1;
			long ylsb = (y >>> i) & 1;

			if(xlsb == ylsb) {
				if (xlsb == 1) { // 1 + 1
					if (carry == 1) {
						r |=  1 << i;
					}
					carry = 1; 
				} else { // 0 + 0
					if (carry == 1) {
						r |=  1 << i;
					}
					carry = 0;
				}
				
			} else {
				// 1 + 0
				if (carry != 1) {
					r |=  1 << i;
					carry = 0;
				} else {
					carry = 1;
				}
			}
		}
		return r;
	}
	
	
}
