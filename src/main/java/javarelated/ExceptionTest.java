package javarelated;

import java.io.IOException;

/** 
 * Description : Runtime异常不需要在函数上声明会抛出
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午11:46:05
 */
public class ExceptionTest {
	public static void test(){
		
		throw new ArithmeticException();
	}

	public static void test2() throws IOException{
		
		throw new IOException();
	}
	
	public static void main(String[] args){
		test();
	}
}
