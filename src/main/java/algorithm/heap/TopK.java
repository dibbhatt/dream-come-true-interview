package algorithm.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/** 
 * Description : 给一堆point(x, y), 返回前k个离远点最近的点,
 *  用k-selection算法, 核心就是那个partition, 平均时间复杂度可以做到O(n).
 * Source : Facebook 面试题
 *          非常好的解释：http://xinpeng.me/?p=607
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-4 
 * Time : 下午6:08:34
 */


class Point {
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x;
	public int y;
	
	public String toString(){
		return "x: " + x + ", y: " + y;
	}
}

class PointComparator implements Comparator<Point>{
	public int compare(Point a, Point b) {
		double distA = Math.sqrt(a.x*a.x + a.y*a.y);
		double distB = Math.sqrt(b.x*b.x + b.y*b.y);
		if (distA > distB){  
			return -1;      // build max heap
		}
		if (distA < distB) {
			return 1;
		}
		return 0;
	}
	
}
public class TopK {
	
	public List<Point> kNearestPoints(List<Point> points, int k) {
		
		PointComparator pc = new PointComparator();
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, pc);
		
		for (Point p : points){
			if (pq.size() >= k) {
				if (pc.compare(pq.peek(), p) < 0) {
					pq.poll();
					pq.offer(p);
				}
				
			} else {
				pq.offer(p);
			}
		}
		
		List<Point> r = new ArrayList<Point>();
		
		for (Point p : pq) {
			r.add(p);
		}
		
		Collections.sort(r, pc);
		return r;
	}
	
	
	@Test
	public void test(){
		
		Queue<Integer> q = new LinkedList();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
		
		
		//虽然限定了5个元素的堆，但是还是能加进去数据
		for (int i = 10; i >= 0; i--) {
			pq.offer(i);
		}
		System.out.println(pq.size());
		
		System.out.println(pq);
		
		List<Point> input = new ArrayList<Point>();
		input.add(new Point(4,2)); 
		input.add(new Point(1,2));
		input.add(new Point(3,2)); 
		input.add(new Point(6,6)); 
		input.add(new Point(5,6)); input.add(new Point(2,3)); 

		System.out.println(kNearestPoints(input, 4));
	}

}
