package algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午3:36:53
 */
public class TopoSort {
	
	//计算图中所有节点的入度
	public void calcInCount(DirectedGraphNode root){
		if (root == null){
			return;
		}
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			DirectedGraphNode curr = q.poll();
			visited.add(curr);
			
			for(DirectedGraphNode dg: curr.neighbors){
				dg.inCount += 1;
				if(!visited.contains(dg)){
					q.add(dg);
				}
			}
		}
		return;
	}
	
	//注意输入的图表示为：图中所有节点构成的数组。
	public ArrayList<DirectedGraphNode> sort(ArrayList<DirectedGraphNode> nodes){
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		if(nodes == null){
			return result;
		}
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		//q.add(root); //假设这个图有唯一一个点入度为0
		
		for(DirectedGraphNode node: nodes){
			if(node.inCount == 0){
				q.add(node);
			}
		}
		
		while(!q.isEmpty()){
			DirectedGraphNode curr = q.poll();
			result.add(curr);
			
			for(DirectedGraphNode dg: curr.neighbors){
				dg.inCount -= 1;
				if(dg.inCount == 0){
					q.add(dg);
				}
			}
		}
		
		return result;
	}
}
