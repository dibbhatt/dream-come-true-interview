package algorithm.highfrequency;
/** 
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-16 
 * Time : 下午4:03:35
 */
public class SortColors {
    public void sortColors(int[] A) {
        int index = sort(A, 0, A.length - 1, 0);
        sort(A, index + 1, A.length - 1, 1);
    }
    
    public int sort (int[] A, int start, int end, int pivot){
        if (start > end){
            return -1;   
        }
        while (start < end){
            while (start < end && A[start] <= pivot){
                start++;
            }
            
            while (start < end && A[end] > pivot){
                end--;
            }
            
            if (start < end){
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
            }
        }
        
        if (A[end] <= pivot){
            return end;
        }
        else 
            return start - 1;
    }
}
