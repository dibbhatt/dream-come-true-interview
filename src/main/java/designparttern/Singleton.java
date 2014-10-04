package designparttern;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-17 
 * Time : 下午9:17:56
 */
public class Singleton {
	
	private double val;
	private static Singleton s = null;
	private Singleton(double val){
		this.val = val;
	}
	public double getVal(){
		return val;
	}
	public static Singleton getInstance(){
		if (s == null) {
			synchronized (s) { 
				if (s == null) {
					s = new Singleton(Math.random());
				}
			}
		}
		return s;
	}
}

class MyThread extends Thread {
	public void run(){
		Singleton s = Singleton.getInstance();
		System.out.println(s.getVal());
	}
}
