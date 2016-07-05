package puzzles;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Description : 
 * you have 100 doors in a row that are all initially closed. You make 100
 * passes by the doors starting with the first door every time. the first time through
 * you visit every door and toggle the door (if the door is closed, you open it, if its
open, you close it). the second time you only visit every 2nd door (door #2, #4,
#6). the third time, every 3rd door (door #3, #6, #9), etc, until you only visit the
100th door. 
 * Source : Google面试题 
 *		    经典开关灯问题
 *			http://chuansongme.com/n/162183
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-4 
 * Time : 下午4:45:55
 */
public class OpenCloseLight {
	
	public int brutalForce() {
		
		boolean[] lights = new boolean[101];
		Arrays.fill(lights, false);
		
		for (int i = 1; i <= 100; i++) {
			for (int j = 0; j <= 100; j = j + i) {				
				lights[j] = !lights[j];
			}	
		}
		
		int r = 0;
		for (int i = 1; i <= 100; i++) {
			if (lights[i]) {
				r++;
			}
		}
		
		return r;
	}
	
	
	public int cleverSolution() {
		int r = 0;
		for (int i = 1; i < 100 / 2; i++) {
			if (i * i > 100) {
				break;
			}
			r++;
		}
		return r;
	}
	
	@Test
	public void test(){
		int r = brutalForce();
		System.out.println(r);
		
		int r2 = cleverSolution();
		System.out.println(r2);
	}
	
}
