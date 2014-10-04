package algorithm.array;

import java.util.ArrayList;

/** 
 * 返回key对应的第一个位置
 * If nums=[3,2,2,1] and k=2, a valid answer is 1.
 *
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-25 
 * Time : 下午9:54:32
 */
public class PartitionArray {
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    int pivotIndex = find(nums, k);
	    int i = 0;
	    int j = nums.size() - 1;
	    
	    while(i < j){
	        while(i < j && nums.get(i) < k){
	            i++;
	        }
	        if(i < j){
	            swap(nums, i, j);
	        }
	        while(i < j && nums.get(j) >= k){
	            j--;
	        }
	        if(i < j){
	            swap(nums, i, j);
	        }
	    }
	    return j + 1;
    }
    
    public void swap(ArrayList<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    
    public int find(ArrayList<Integer> nums, int k){
        int min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i < nums.size(); i++){
            if(Math.abs(k - nums.get(i)) < min){
                index = 0;
            }
        }
        return index;
    }
}
