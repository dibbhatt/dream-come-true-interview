package algorithm.array;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-9 
 * Time : 下午9:38:45
 */
public class MaximalRectangleTest {
	MaximalRectangle mr = new MaximalRectangle();
	
	@Test
	public void testMaximalRectangle(){
		char[][] a = new char[3][3];
		a[0][0] = '0'; a[0][1] = '1'; a[0][2] = '1';
		a[1][0] = '0'; a[1][1] = '0'; a[1][2] = '1';
		a[2][0] = '0'; a[2][1] = '1'; a[2][2] = '0';
		int area = mr.maximalRectangle(a);
		System.out.println(area);
		
		char[][] b = new char[1][2];
		b[0][0] = '0'; b[0][1] = '1';
		area = mr.maximalRectangle(b);
		System.out.println(area);
		
	}
	
}
