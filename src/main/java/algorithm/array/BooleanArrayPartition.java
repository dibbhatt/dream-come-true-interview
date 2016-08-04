package algorithm.array;

/**
 * Description :
 * Source : This problem is in **EPI chapter 6 section 6.1 page 62. Similar problem is in the Leetcode https://leetcode.com/problems/sort-colors/
 * Created_By : xmpy
 * Time : Aug 1, 2016 9:53:44 PM  
 */
public class BooleanArrayPartition {
	public void swap(boolean[] bools, int i, int j) {
	    if ( i == j ) {
	        return;
	    }
		boolean temp = bools[i];
		bools[i] = bools[j];
		bools[j] = temp;
		
	}
	public void partition(boolean[] bools) {
        if (bools == null || bools.length <= 1) {
            return;
        }
        
		int equals = bools.length - 1;
		int trues = bools.length - 1;
		
		/* Invariants
		 * [0, equals] : unclassified
		 * (equals, trues] : falses
		 * (trues, bools.length) : trues
		 */ 
		while (equals >= 0) {
			// true
			if (bools[equals]) {
				swap(bools, equals, trues);
				equals--;
				trues--;
			} else {
				equals--;
			}
		}
	}
}
