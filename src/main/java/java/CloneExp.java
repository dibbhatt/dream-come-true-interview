package java;

import java.util.ArrayList;

/** 
 * Description : Need to dig into!!! A little confuse about CloneExp!!!
 * Source : Java 程序员面试笔试宝典
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午5:30:27
 */

public class CloneExp implements Cloneable{
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public Object clone() {
		CloneExp res = null;
		try {
			res = (CloneExp) super.clone();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		res.arr = (ArrayList<Integer>) this.arr.clone();
		return res;
	}
	
}
