package algorithm.search;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午5:07:47
 */
public class NextPermutationTest {
	NextPermutation np = new NextPermutation();
	
	@Test
	public void testNextPermutation(){
		int[] num = {1,1};
		np.nextPermutation(num);
	}
	

}
