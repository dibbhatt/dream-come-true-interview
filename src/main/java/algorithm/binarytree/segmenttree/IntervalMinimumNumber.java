package algorithm.binarytree.segmenttree;

import java.util.ArrayList;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 19, 2015 
 * Time : 12:04:23 AM
 */

 //Definition of Interval:
class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
 }
class SegmentTreeNode {
    public int start, end, min;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int min) {
        this.start = start;
        this.end = end;
        this.min = min;
        this.left = this.right = null;
    }
}
class SegmentTree2 {
   public static SegmentTreeNode build(int[] arr, int start, int end) {
       if (start == end) {
           return new SegmentTreeNode(start, end, arr[start]);
       }
       int mid = start + (end - start) / 2;
       SegmentTreeNode left = build(arr, start, mid);
       SegmentTreeNode right = build(arr, mid + 1, end);
       int min = Math.min(left.min, right.min);
       SegmentTreeNode root = new SegmentTreeNode(start, end, min);
       root.left = left; root.right = right;
       return root;
   }
   
   public static int query(SegmentTreeNode root, int start, int end) {
       if (root.start == start && root.end == end) {
           return root.min;
       }
       
       int mid = root.start + (root.end - root.start) /2;
       if (end <= mid) {
           return query(root.left, start, end);
       }
       if (start >= (mid + 1)) {
           return query(root.right, start, end);
       }
       return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
   }
}


public class IntervalMinimumNumber {
	   public ArrayList<Integer> intervalMinNumber(int[] A, 
               ArrayList<Interval> queries) {
// write your code here
	ArrayList<Integer> result = new ArrayList<Integer>();
	SegmentTreeNode root = SegmentTree2.build(A, 0, A.length - 1);
	for (Interval interval : queries) {
	result.add(SegmentTree2.query(root, interval.start, interval.end));
	}
	return result;
}
}
