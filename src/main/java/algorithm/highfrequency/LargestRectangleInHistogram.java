package algorithm.highfrequency;

import java.util.Stack;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 11, 2015 
 * Time : 10:22:52 PM
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            	System.out.println("height: " + h);
            	System.out.println("width: " + w);

                System.out.println("max: " + max);

            }
            stack.push(i);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
    	LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
    	int[] height= new int[]{0,3,2,2,2,3,0};
    	System.out.println(lr.largestRectangleArea(height));       //lr.largestRectangleArea(height);
    }
}
