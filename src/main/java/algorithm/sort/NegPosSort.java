package algorithm.sort;

import org.junit.Test;

/** 
 * Description : 保证负数在正数前面即可
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-20 
 * Time : 下午6:05:19
 */
public class NegPosSort {
	
	public void sort(int[] A){
		int place_i = 0;
		
		for(int i = 0; i < A.length; i++) {
			if (A[i] < 0){
				swap(A, place_i, i);
				place_i++;
			}
		}
	}
	
	public void swap(int[] A, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
		
	}
	
	@Test
	public void test(){
		int[] A = {1,32,-42,-1,1,3,4,-1,3,-23};
		sort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	} 

}
