package designparttern;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-6 
 * Time : 下午4:27:30
 */
public class Singleton2 {
	
	private double val;
	private static Singleton2 s = new Singleton2(0);
	private Singleton2(double val){
		this.val = val;
	}
	public double getVal(){
		return val;
	}
	public static Singleton2 getInstance(){
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton2.class.getClassLoader());

		Thread thread = new MyThread2();
        System.out.println(thread instanceof Object);

		thread.run();
	}
}

class MyThread2 extends Thread {
	public void run(){
		Singleton2 s = Singleton2.getInstance();
		System.out.println(s.getVal());
	}
}

