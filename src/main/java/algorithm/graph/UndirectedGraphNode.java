package algorithm.graph;

import java.util.ArrayList;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午3:43:22
 */
public class UndirectedGraphNode {
	 int label;
	 ArrayList<UndirectedGraphNode> neighbors;
	 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
