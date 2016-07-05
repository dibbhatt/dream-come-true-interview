package algorithm.binarytree.segmenttree;

import java.util.ArrayList;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 22, 2015 
 * Time : 9:36:26 PM
 */

class TreeNode {
    public int rstart;
    public int rend;
    public int count;
    
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode (int rstart, int rend, int count) {
        this.rstart = rstart;
        this.rend = rend;
        this.count = count;
    }
}

class ValueSegmentTree {
    
    public static TreeNode buildEmptyTree(int rstart, int rend ) {
        if ( rstart == rend ) {
            return new TreeNode(rstart, rend, 0);
        }
        TreeNode root = new TreeNode(rstart, rend, 0);
        int rmid = rstart + ( rend - rstart) /2;
        root.left = buildEmptyTree(rstart, rmid);
        root.right = buildEmptyTree(rmid + 1, rend);
        return root;
    }
    
    public static void insert(TreeNode root, int val) {
        if ( val > root.rend && val < root.rstart ) {
            return ;
        }
        root.count++;

        if (root.rstart == root.rend && root.rstart == val) {
            return;
        }
        int rmid = root.rstart + (root.rend - root.rstart) /2;
        if ( val <= rmid ){
            insert(root.left, val);
        } else {
            insert(root.right, val);   
        }
    }
    
    public static int query(TreeNode root, int qstart, int qend) {
        if (qstart <= root.rstart && qend >= root.rend) {
            return root.count;
        }
        if (qstart > root.rend || qend < root.rstart) {
            return 0;
        }
        int rmid = root.rstart + ( root.rend - root.rstart) /2;

        if ( qend <= rmid ){
            return query(root.left, qstart, qend);
        }
        
        if ( qstart > rmid ){
            return query(root.right, qstart, qend);
        }
        return query(root.left, qstart, rmid) + query(root.right, rmid + 1, qend);
    }
}


public class CountOfSmallerNumberBeforeItself {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
     
     
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        int max = 0;
        int min = 10000;
        for ( int a : A) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        TreeNode root =  ValueSegmentTree.buildEmptyTree(min, max);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for ( int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val == 0) {
                result.add(0);
            }
            result.add(ValueSegmentTree.query(root, 0, val - 1));
            
            ValueSegmentTree.insert(root, val);
        }
        return result;
    }
}
