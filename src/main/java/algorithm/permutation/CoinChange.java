package algorithm.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jan 21, 2016 
 * Time : 10:27:28 PM
 */
public class CoinChange {
	
	private int[] sorted;
	public int coinChange(int amount) {
    	if(amount == 0) {
    		return 0;
    	}
		
		int nearestIdx = binarySearch(amount);
		if ( nearestIdx == -1) {
			return -1;  // no solution
		}
		if ( sorted[nearestIdx] == amount) {
			return 1;
		}
		List<Integer> leftRets = new ArrayList<Integer>();
		for (int idx = nearestIdx; idx >= 0; idx--) {
			int leftResult = coinChange(amount - sorted[idx]);
			if (leftResult != -1) {
				leftRets.add(leftResult);
			}
		}
		if (leftRets.size() == 0)
			return -1;
		Collections.sort(leftRets);
		return leftRets.get(0) + 1;
	}
	
	private int binarySearch(int value) {
		// find the first value which is less than given value
		// If there is no such kind of value, return -1.
		int len = sorted.length;
		if (len < 1) {
			return -1;
		} 
		if (len == 1) {
			if (sorted[0] <= value) {
				return 0;
			} else {
				return -1;
			}
		}
		int start = 0;
		int end = len - 1;
		
		
		while (start + 1 < end) {
			int mid = start + (end - start) /2;
			if (sorted[mid] < value) {
				start = mid;
			} else if (sorted[mid] > value) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		
		if (sorted[end] <= value) {
			return end;
		}
		if (sorted[start] <= value) {
			return start;
		}
		return -1;
	}
	
	
    public int coinChange(int[] coins, int amount) {
    	
    	if(amount == 0) {
    		return 0;
    	}
    	Set<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < coins.length; i++) {
    		set.add(coins[i]);
    	}
    	sorted = new int[set.size()];
    	int idx = 0;
    	for (Integer value : set) {
    		sorted[idx++] = value; 
    	}
		Arrays.sort(sorted);

    	return coinChange(amount);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(new int[]{186, 419, 83, 408}, 6249));
	}

}
