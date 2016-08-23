package algorithm.array;

public class RotateArray2 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int carry = nums[i];
            int next = (i + k) % nums.length;
            while(next != i){
                int temp = nums[next];
                nums[next] = carry;
                carry = temp;
                count++;
                next = (next + k) % nums.length;
            }
            nums[i] = carry;
            count++;
        }
    }
}
