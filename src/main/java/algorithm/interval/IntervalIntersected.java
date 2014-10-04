package algorithm.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/** 
 * Description : 有n个左右端点都为整数的区间，判断每个区间是否有与其它某个区间相交（区间端点重合也算相交）。
 * Source : Itint5
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-30 
 * Time : 下午1:14:33
 */
public class IntervalIntersected {
	
	class IntervalPair {
		public int index = 0;
		public Interval m = null;
		
		public IntervalPair(int index, Interval m) {
			this.index = index;
			this.m = m;
		}
	}
	
	class IntervalComparator implements Comparator<IntervalPair>{
		
		public int compare(IntervalPair a, IntervalPair b) {
			return a.m.start - b.m.start;
		}
	}
	
    // intervals包含n个区间
    // 结果存放到isIntersected中(已分配空间)
    // isIntersected[i]表示第i个区间是否与其它区间相交
    public void intersected(Interval[] intervals, boolean[] isIntersected) {
    	
    	if (intervals.length == 0) {
    		return;
    	}
    	
    	IntervalPair[]  inpairs = new IntervalPair[intervals.length];
    	
    	
    	for (int i = 0; i < intervals.length; i++) {
    		inpairs[i] = new IntervalPair(i, intervals[i]);
    	}
    	
    	Arrays.sort(inpairs, new IntervalComparator());
    	
    	Interval pre = new Interval();
    	pre.start = inpairs[0].m.start;
    	pre.end = inpairs[0].m.end;
    	
    	isIntersected[inpairs[0].index] = false;
    	
    	for (int i = 1; i < inpairs.length; i++) {
    		if (inpairs[i].m.start <= pre.end) {
    			pre.end = Math.max(inpairs[i].m.end, pre.end);
    			
    			isIntersected[inpairs[i-1].index] = true;
    			isIntersected[inpairs[i].index] = true;
    		} else {
    			pre.start = inpairs[i].m.start;
    			pre.end = inpairs[i].m.end;
    			isIntersected[inpairs[i].index] = false;
    		}
    	}
    }
}


