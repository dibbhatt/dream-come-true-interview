package algorithm.stack;

import java.util.Stack;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-10 
 * Time : 下午7:53:39
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
            }
            stack.push(i);
        }
        
        return max;
    	/*
        int maxArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        
        for (int i = 0; i < height.length; i++){
            int idx = s.peek();
            while (idx != -1 && height[idx] >= height[i]){
                idx = s.pop();
                int area = height[idx]  * (idx  + 1);
                if (s.peek() != -1)
                    area = height[idx] * (idx - s.peek());
                maxArea = maxArea > area ? maxArea : area;
                idx = s.peek();
            }
            s.push(i);
        }
        int idx = s.peek();
        while (idx != -1){
            idx = s.pop();
            int area = height[idx] * (idx + 1);
            if (s.peek() != -1)
                area = height[idx] * (idx - s.peek());
            maxArea = maxArea > area ? maxArea : area;   
            idx = s.peek();
        }
        
        for (int i = height.length - 1; i >= 0; i--){
            idx = s.peek();
            while (idx != -1 && height[idx] >= height[i]){
                idx = s.pop();
                int area = height[idx] * (height.length - idx);
                if (s.peek() != -1)
                    area = height[idx] * (s.peek() - idx);
                maxArea = maxArea > area ? maxArea : area;
                idx = s.peek();
            }
            s.push(i);
        }
        
        idx = s.peek();
        while (idx != -1){
            idx = s.pop();
            int area = height[idx] * (height.length - idx);
            if (s.peek() != -1)
                area = height[idx] * (s.peek() - idx);
            maxArea = maxArea > area ? maxArea : area; 
            idx = s.peek();
        }
        
        
        return maxArea;
        */
    }
}
