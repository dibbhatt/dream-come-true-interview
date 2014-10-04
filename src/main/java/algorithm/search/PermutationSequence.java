package algorithm.search;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-14 
 * Time : 下午9:52:30
 */
public class PermutationSequence {
    public void next(int[] nums){
        int len = nums.length;
        int i = len - 1;
        int j = i;
        for (; j > 0; j--){
            if (nums[j] > nums[j - 1]){
                break;
            }
        }
        if (j != 0){
            for (int k = len - 1; k > 0; k--){
                if(nums[k] > nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[k];
                    nums[k] = temp;
                    break;
                }
            }
        }

        swap(nums, j , nums.length - 1);

    }
    
    public  void swap (int[] nums, int start, int end){
        for (int i = 0; i < (end - start + 1)/2; i++){
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
    
    
    
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        for (int i = 0; i < k - 1; i++){
            next(nums);
        }
        String result = "";
        for (int i = 0; i < n; i++){
        	result += nums[i];
        }
        return result;
    }
    
    @Test
    public void test(){
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(3, 2));
    	
    }
}
