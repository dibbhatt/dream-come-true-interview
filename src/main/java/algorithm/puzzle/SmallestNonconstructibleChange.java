package algorithm.puzzle;

import java.util.Arrays;

/**
 * Description :
 * Source : EPI chapter 4.1 p 31 
 * Created_By : xmpy
 * Time : Jul 7, 2016 11:30:19 AM  
 */
public class SmallestNonconstructibleChange {

	public int smallestNonconstructibleValue(int[] input) {
		if ( input == null ) {
			return -1; // Invalid input.
		}
		Arrays.sort(input);
		int canReach = 0;
		for ( int i = 0; i < input.length; i++) {
			if ( input[i] > (canReach + 1)) {
				return canReach + 1;
			}
			canReach += input[i];
		}
		
		return canReach + 1;
	}
}
