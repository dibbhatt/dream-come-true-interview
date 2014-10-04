package algorithm.graph;

import java.util.ArrayList;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午3:44:04
 */
public class DirectedGraphNode {
	 int label;
	 int inCount = 0;
	 ArrayList<DirectedGraphNode> neighbors;
	 DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
}
