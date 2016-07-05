package javarelated;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/** 
 * Description : 设计一个输入流的类，该类的作用为在读文件时把文件中的大写字母转换为小写字母，把小写字母转换为大写字母
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午11:56:13
 */
public class MyOwnInputStream extends FilterInputStream{
	public MyOwnInputStream(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException {
		int c = 0;
		if ((c = super.read()) != -1) {
			if (Character.isLowerCase((char)(c))){
				return Character.toLowerCase((char)c);
			} 
			else if (Character.isUpperCase((char)c)) {
				return Character.toLowerCase((char)c);
			} else {
				return c;
			}
		}
		else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		int c;
		try{
			InputStream is = new MyOwnInputStream(new BufferedInputStream(new FileInputStream("text.txt")));
		}catch (Exception e) {
			
		}
	}
	
}
