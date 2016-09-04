package algorithm.stack;

import org.junit.Test;

public class LengthLongestPathTest {
	
	@Test
	public void testLargestRectangleArea(){
		LengthLongestPath llp = new LengthLongestPath();
		// Output 32
		//System.out.println(llp.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		// Output 0
		System.out.println(llp.lengthLongestPath("a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));

	}
}
