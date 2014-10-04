package algorithm.search;



import java.util.List;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-2 
 * Time : 下午4:41:10
 */
public class CombineSum2Test {
	public CombinationSum2 cst = new CombinationSum2();
	
	@Test
	public void testCombineSum(){
		int[] num = {1,1};
		
		List<List<Integer>> r = cst.combinationSum2(num, 2);
		
		System.out.println(r);
		
		num = new int[]{1,1,1,2,3};
		r = cst.combinationSum2(num, 3);
		System.out.println(r);
	}
	

}
