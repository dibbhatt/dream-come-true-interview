package algorithm.binarytree.segmenttree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 17, 2015 
 * Time : 9:20:06 PM
 */

class Node {
    public Node left = null;
    public Node right = null;
    public int mid = 0;
    public int li = 0;
    public int ri = 0;
    public int val = 0;
    public Node(int li, int ri){
    	this.mid = li + (ri - li)/2;
    	this.li = li;
    	this.ri = ri;
    }
}

class SegmentTree {
    
    private Node root = null;
    
    public Node buildTree(int li, int ri) {
        Node root = new Node(li, ri);
        if (li > ri) {
            return null;
        }
        if (li == ri) {
            return root;
        }
        root.left = buildTree(li, root.mid);
        root.right = buildTree(root.mid + 1, ri);
        return root;
    }
    
    public void insertTree(Node root, int li, int ri, int val) {
	    if (root == null) {
	    	return;
	    }
	    if (root.val > val) {
	    	return;
	    }
    	if (li == root.li && ri == root.ri) {
	    	  root.val = Math.max(root.val, val);
	    	  return;
    	}
    	int mid = root.mid;
    	if (ri <= mid) {
    		insertTree(root.left, li, ri, val);
    		return;
    	}
    	if (li >= mid + 1) {
    		insertTree(root.right, li, ri, val);
    		return;
    	}
    	
    	insertTree(root.left, li, mid, val);
    	insertTree(root.right, mid+1, ri, val);
    	
    }
    
}

public class Skyline {
	private int[] map = null;
	public void calc(List<int[]> result, Node root, int parentVal) {
		if (root == null) {
			return;
		}
		root.val = Math.max(root.val, parentVal);
		if (root.li == root.ri) {
			if (result.size() == 0 || result.get(result.size() - 1)[1] != root.val)
				result.add(new int[]{map[root.li], root.val});
		}
		calc(result, root.left, root.val);
		calc(result, root.right, root.val);
		
	}
	
    public List<int[]> getSkyline(int[][] buildings) {
    	// I need a set which can be sorted, so think about TreeSet.
        Set<Integer> ts = new TreeSet<Integer>();
    	for (int[] line : buildings) {
    		ts.add(line[0]);
    		ts.add(line[1]);
    	}
    	int n = ts.size();
    	map = new int[n];
    	Iterator<Integer> it = ts.iterator();
    	HashMap<Integer, Integer> toIndex= new HashMap<Integer, Integer>();
    	int i = 0;
    	while (it.hasNext()) {
    		int val = it.next();
    		map[i] = val;
    		toIndex.put(val, i);
    		i++;
    	}
    	SegmentTree st = new SegmentTree();
    	Node root = st.buildTree(0, n - 1);
    	for (int[] line : buildings) {
    		st.insertTree(root, toIndex.get(line[0]), toIndex.get(line[1]) - 1, line[2]);
    	}
        List<int[]> result = new ArrayList<int[]>();
        calc(result, root, 0);
        return result;
    }
    public static void main(String[] args){
    	Skyline s = new Skyline();
    	int[][] input = new int[4][3];
    	input[0] = new int[]{0,3,3};
    	input[1] = new int[]{1,5,3};
    	input[2] = new int[]{2,4,3};
    	input[3] = new int[]{3,7,3};

    	List<int[]> r = s.getSkyline(input);
    	for (int [] rr : r) {
    		for (int ii : rr) {
    			System.out.println(ii);
    		}
			System.out.println("\n");

    	}
    }
}
