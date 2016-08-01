package algorithm.array;

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
