package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : EPI 6.17 Spiral Matrix Variant 2
 * Created_By : xmpy
 * Time : Aug 15, 2016 6:53:54 PM  
 */
public class EnumeratePairsInSpiralOrder {
	private final int[][] SHIFT = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; //right, down, left, up
	public List<List<Integer>> enumerate(int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int x = 0;
		int y = 0;
		
		int directCount = 0;
		int already = 0;
		int currStep = 1;
		for (int i = 0; i < n; i++) {
			List<Integer> r = new ArrayList<Integer>();
			r.add(x); r.add(y);
			res.add(r);
			if (already == currStep) { //Change the direction
				directCount += 1;
				if (directCount % 2 == 0) {
					currStep += 1;
				}
				already = 0;
			}
			x += SHIFT[directCount % 4][0];
			y += SHIFT[directCount % 4][1];
			already++;
		}
		return res;
	}
}
