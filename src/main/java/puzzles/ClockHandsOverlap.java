package puzzles;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Description : How many times a day do the minute and hour hands of a clock overlap?
 * 
 * 答案在：http://blog.sina.com.cn/s/blog_637998c30101fxfk.html 写的非常好
 * 
 * Source : Amazon 面试题 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-4 
 * Time : 下午1:56:18
 */
public class ClockHandsOverlap {
	
	public double w_hour = 360.0 / (12 * 3600); //时针速度
	public double w_minute = 360.0 / (60 * 60); //秒针速度
	public double w_second = 360 / 60;
	
	
	public ArrayList<Double> OverlapTimes(double w_fast, double w_slow) {
		ArrayList<Double> r = new ArrayList<Double>();
		int n = (int) (24 * 3600 * w_fast / 360) ; // 快的指针绕多少圈 
		
		for (int k = 0; k < n; k++) {
			double t = 360 / (w_fast - w_slow) * (k - (int)(k * (w_slow / w_fast)));
			System.out.println(k);
			System.out.println(t);
			r.add(t);	
		}
		
		return r;
	}

	
	@Test
	public void test(){
		ArrayList<Double> r = OverlapTimes(w_minute, w_hour);
		System.out.println(r);
		System.out.println(r.size());

	}
}
