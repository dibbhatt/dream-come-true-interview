package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-29 
 * Time : 上午12:16:08
 */
public class HorseJump {
	 class Point{
	        public int x;
	        public int y;
	        Point(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	        
	    }
	    
	    public boolean canJump(int x, int y, int x2, int y2) {
	        
	        Queue<Point> q = new LinkedList();
	        
	        q.add(new Point(x,y));
	        
	        while (!q.isEmpty()) {
	            int size = q.size();
	            for (int i = 0; i < size; i++){
	                Point curr = q.poll();
	                if (curr.x == x2 && curr.y == y2){
	                    return true;
	                }
	                
	                q.add(new Point(curr.x + 1, curr.y + 2));
	                q.add(new Point(curr.x + 1, curr.y - 2));
	                q.add(new Point(curr.x - 1, curr.y + 2));
	                q.add(new Point(curr.x - 1, curr.y - 2));
	                q.add(new Point(curr.x + 2, curr.y + 1));
	                q.add(new Point(curr.x + 2, curr.y - 1));
	                q.add(new Point(curr.x - 2, curr.y + 1));
	                q.add(new Point(curr.x - 2, curr.y - 1));
	            }
	        }
	        
	        return false;
	    }
}
