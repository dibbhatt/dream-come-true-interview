package algorithm.array;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-25 
 * Time : 下午9:56:28
 */
public class PartitionArrayTest {
	@Test
	public void testPartitionArray(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(2);
		nums.add(2);
		nums.add(1);
		
		PartitionArray pa = new PartitionArray();
		
		int r = pa.partitionArray(nums, 2);
		System.out.println(nums);
		System.out.println(r);
	}
}
