package algorithm.binarysearch;

import org.junit.Test;

/** 
 * Description :
 * Source : 宜信大数据面试 https://leetcode.com/problems/find-peak-element/
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-14 
 * Time : 下午7:53:41
 */
public class PeekFinding {
	public int maxNumberIndex(int[] a) {
	    if (a == null || a.length == 0) {
	        return -1; 
	    }
	    
	    int start = 0;
	    int end = a.length - 1;
	    
	    //Guarantee that we have more than two elements
	    while (start + 1 < end) {  
	        int mid = start + (end - start) / 2;
	        
	        // Because we have more than two elements, mid will never equal 
	        // to start or end. 
	        
	        if (a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1]) {
	            return mid;
	        }
	        
	        if (a[mid] < a[mid + 1]) {
	            start = mid + 1;
	        } else {
	            end = mid;
	        }
	    }
	    
	    if (a[start] >= a[end]) {
	        return start;
	    }
	    return end;
	}
	
	@Test
	public void test() {
		int[] a = null;
		System.out.println(maxNumberIndex(a));
		a = new int[]{};
		System.out.println(maxNumberIndex(a));
		a = new int[]{ 1,2,5,2,1};
		System.out.println(maxNumberIndex(a));
		a = new int[]{1,2,4,5,1};
		System.out.println(maxNumberIndex(a));
		a = new int[]{1,2};
		System.out.println(maxNumberIndex(a));
		a = new int[]{5, 4, 3, 2, 1};
		System.out.println(maxNumberIndex(a));
		
	} 


}
