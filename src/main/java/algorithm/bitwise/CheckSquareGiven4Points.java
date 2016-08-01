package algorithm.bitwise;

import java.util.Scanner;

/**
 * Description : Given coordinates of four points in a plane, find if the four points form a square or not.
 * Source :  http://www.practice.geeksforgeeks.org/problem-page.php?pid=907
 * Created_By : xmpy
 * Time : Jul 30, 2016 3:41:05 PM  
 */
public class CheckSquareGiven4Points {

	
	/**
	 *  We assume the input quadrangle (四边形) like this:
	 *  
	 *  a----b
	 *  |    |
	 *  |    |
	 *  c----d
	 *  
	 */
	public static boolean checkSquareGiven2ParallelEdges(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		
		int abx = ax - bx;
		int aby = ay - by;
		int cdx = cx - dx;
		int cdy = cy - dy;
		int acx = ax - cx;
		int acy = ay - cy;
		int bdx = bx - dx;
		int bdy = by - dy;
		
		// vector ab should be equal to vector cd.
		if (abx != cdx || aby != cdy) {
			return false;
		}
		
		// vector ac should be equal to vector bd.
		if (acx != bdx || acy != bdy) {
			return false;
		}
		
		// Now this quadtangle should be a parallelogram
		// vector ab should be perpendicular to ac
		if ((abx * acx + aby * acy) != 0) {
			return false;
		}
		
		// Now this quadtangle should be a rectangle
		// The length of ab should be equal to ac
		if ( (abx*abx + aby*aby) != (acx*acx + acy*acy)) {
			return false;
		}
		// Now this quadtangle should be a square!
		return true;
	}
	
	public static boolean checkSquareGiven4Points(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		if (checkSquareGiven2ParallelEdges(ax, ay, bx, by, cx, cy, dx, dy)){
			return true;
		}
		if (checkSquareGiven2ParallelEdges(ax, ay, bx, by, dx, dy, cx, cy)){
			return true;
		}
		if (checkSquareGiven2ParallelEdges(ax, ay, cx, cy, bx, by, dx, dy)){
			return true;
		}
		if (checkSquareGiven2ParallelEdges(ax, ay, cx, cy, dx, dy, bx, by)){
			return true;
		}
		if (checkSquareGiven2ParallelEdges(ax, ay, dx, dy, cx, cy, bx, by)){
			return true;
		} 
		if (checkSquareGiven2ParallelEdges(ax, ay, dx, dy, bx, by, cx, cy)){
			return true;
		}	
		return false;
	}
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int ax = sc.nextInt();
            int ay = sc.nextInt();
            int bx = sc.nextInt();
            int by = sc.nextInt();
            int cx = sc.nextInt();
            int cy = sc.nextInt();
            int dx = sc.nextInt();
            int dy = sc.nextInt();
            if (checkSquareGiven4Points(ax, ay, bx, by, cx, cy, dx, dy)) {
            	System.out.println("1");
            } else {
            	System.out.println("0");
            }

            t--;
        }
	}
}
