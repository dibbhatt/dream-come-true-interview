package algorithm.highfrequency;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Description : Find the count of 2, 5, 8 in the numbers in range (a, b]
 * 求给定区间(a,b]内数字包含2,5,8的个数
 * Source : Hulu 电面面试题
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-3 
 * Time : 下午7:54:33
 */
public class Count258inRange {
	
	public int countNumInOne2N(int N, int num) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//int i = 0;
		int pre = N;
		int post = 0;
		while (N != 0) {
			nums.add(N % 10);
			N = N / 10;
		}
		
		int count = 0;
		
		for (int i = 0; i < nums.size(); i++) {
			
			int curr = nums.get(i);
			pre -= curr;
			pre /= 10;
			
			if (curr < num) {
				count += pre * (int)(Math.pow(10, i));
			} else if (curr == num) {
				count += pre * (int)(Math.pow(10, i)) + post;
			} else {
				count += (pre + 1) * (int)(Math.pow(10, i));
			}
			post += curr * (int)(Math.pow(10, i));
		}
		
		
		return count;
	}
	
	
	@Test
	public void test(){
		int count = countNumInOne2N(12113, 1);
		System.out.println(count);
		
		count = countNumInOne2N(12, 1);
		System.out.println(count);
		
		count = countNumInOne2N(93, 1);
		System.out.println(count);  //Expect 20
	} 

}
