package algorithm.binarytree.segmenttree;

import java.util.ArrayList;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 20, 2015 
 * Time : 12:01:11 AM
 */
class Node2 {
    public long sum;
    public int start, end;
    public Node2 left, right;
    public Node2 (int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum; 
    }
}

class SegmentTree3 {
    public static Node2 build(int[] A, int start, int end) {
        if (start == end) {
            return new Node2(start, end, A[start]);
        }
        Node2 root = new Node2(start, end, 0);
        int mid = start + (end - start) /2;
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public static long query(Node2 root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = start + (end - start) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } 
        if (start > mid) {
            return query(root.right, start, end);
        }
        
        return query(root.left, start, mid) + query(root.right, mid +1, end);
        
    }
}

public class IntervalSum {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<Long>();
        // write your code here
        Node2 root = SegmentTree3.build(A, 0, A.length - 1);
        for (Interval interval: queries) {
            result.add(SegmentTree3.query(root, interval.start, interval.end));
        }
        return result;                         
    }
}