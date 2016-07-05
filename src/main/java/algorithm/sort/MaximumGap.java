package algorithm.sort;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jul 28, 2015 
 * Time : 11:48:27 PM
 */
public class MaximumGap {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        
        if (max == min) {
            return 0;
        }
        int bucketCapacity = (max - min) / (n - 1);
        if (bucketCapacity < 1) {
            bucketCapacity = 1;
        }
        
        int bucketCount = (max - min) / bucketCapacity  + 1;
        
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / bucketCapacity;
            System.out.println("index: " + index);
            if (buckets[index][0] == -1) {
                buckets[index][0] = nums[i];
                buckets[index][1] = nums[i];
                continue;
            }
            if (nums[i] < buckets[index][0]) {
                buckets[index][0] = nums[i];
            }
            if (nums[i] > buckets[index][1]) {
                buckets[index][1] = nums[i];
            }
        }
        for (int i = 0; i < bucketCount; i++ ) {
        	System.out.println("00 " + buckets[i][0]);
        	System.out.println("11 " + buckets[i][1]);
        }
        
        int maxGap = 0;
        int preMax = 0;
        
        int startI = 0;
        for (startI = 0; startI < bucketCount - 1; startI++) {
        	System.out.println(buckets[startI][0]);

            if (buckets[startI][1] != -1) {
                preMax = buckets[startI][1];
                break;
            }
        }
        System.out.println(startI);

        System.out.println(bucketCount);
        for (int i = startI + 1; i < bucketCount; i++) {
        	System.out.println(buckets[i][0]);
            if (buckets[i][0] != -1) {
                int gap = buckets[i][0] - preMax;
                preMax = buckets[i][1]; 
                if (gap > maxGap) {
                    maxGap = gap;
                }
            }
        }
        return maxGap;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[]{1, 10000000};
    	maximumGap(nums);
    } 
	
	
}
