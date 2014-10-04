package algorithm.stack;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-10 
 * Time : 下午7:55:47
 */
public class LargestRectangleInHistogramTest {
	LargestRectangleInHistogram lrs = new LargestRectangleInHistogram();
	
	@Test
	public void testLargestRectangleArea(){
		int[] height = new int[] {0};
		
		int r = lrs.largestRectangleArea(height);
		System.out.println(r);
		
		int[] height2 = new int[] {2,1,5,6,2,3};
		r = lrs.largestRectangleArea(height2);
		System.out.println(r);
		
		int[] height3= new int[] {2,4,4};
		r = lrs.largestRectangleArea(height3);
		System.out.println(r);
	}
	
}
