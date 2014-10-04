package algorithm.probability;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * 使用random 生成 randomn的数
 * Date : 2014-9-16 
 * Time : 下午3:06:06
 */
public class RandMToRandN {
	
	int randM(int m){
		return (int)(Math.random() * m) + 1;
	}
	
	
	int rand(int m, int n){
		int r = randM(m);
		int max = m;
		//System.out.println("randM: " + r);
		while (max < n) {
			
			r = m * (r - 1) + randM(m);
			max = m * max;
		}		
		
		return r;
	}
	
	int randN(int m, int n){
		int r = rand(m, n);
		
		while(r > n){
			r = rand(m, n);
		}
		
		return r;
	}
	
	@Test
	public void test(){
	//	int r = rand(5, 7);
		for (int i = 0; i < 100; i++){
			int r = randN(5, 7);
			System.out.println(r);
		}
	}
	
}
