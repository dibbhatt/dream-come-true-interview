package algorithm.binarysearch;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-12 
 * Time : 下午1:43:27
 */
public class SearchInRotatedSortedArray {
	
	/* 比我做的更清楚的思路，先判断中间那个点在哪里
	 * public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while
        
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
	 */
	
	
	 public int search(int[] A, int target) {
        if(A.length == 0)
            return -1;
            
        int left = 0;
        int right = A.length - 1;
        
        while(left + 1 < right){
            int mid = (left + right) /2;
            if(A[mid] == target)
                return mid;
            if(A[mid] > target){ //如果target可能在左侧
                if(A[left] < A[mid] ){   //如果左侧是正常的
                    if(A[left] <= target)  //如果比最左边的元素还要大，说明就在左侧
                        right = mid - 1;
                    else                   //否则在右侧
                        left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(A[right] > A[mid]){
                    if(target <= A[right])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        if(A[left] == target){
            return left;
        }
        if(A[right] == target){
            return right;
        }
        return -1;
    }
		
}
