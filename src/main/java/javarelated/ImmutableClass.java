package javarelated;

import java.util.Date;

/** 
 * Description :
 * Source : Java笔试面试宝典
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午7:58:19
 */


class Answer1 {
	final private Date d;
	
	public Answer1(Date d) {
		this.d = d;
	}
	public void printState(){
		System.out.println(d);
	}
	
}

class Answer2 {
	final private Date d;
	
	public Answer2(Date d) {
		this.d = (Date)d.clone(); //解除了引用关系
	}
	public void printState(){
		System.out.println(d);
	}
	
}




public class ImmutableClass {
	
	
	public static void main(String[] args) {
		Date d = new Date();
		Answer1 ic = new Answer1(d);  //Answer1 不是不可变类
		ic.printState();
		d.setDate(5);
		ic.printState();
		//会输出
		/*
		 * Sun Dec 07 20:13:17 CST 2014
			Fri Dec 05 20:13:17 CST 2014
		 * 
		 */
		d = new Date();
		Answer2 ic2 = new Answer2(d);  //Answer1 不是不可变类
		ic2.printState();
		d.setDate(5);
		ic2.printState();
		
		System.out.println(Math.round(-1.5));
		System.out.println(Math.round(-1.6)); //-2
		
		char c[] = {'h','e','l','l','o'};
		String a = "hello";
		System.out.println(a.equals(d));
	}
	
}
