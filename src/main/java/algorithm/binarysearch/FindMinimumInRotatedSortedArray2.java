package algorithm.binarysearch;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-29 
 * Time : 下午6:10:44
 */
public class FindMinimumInRotatedSortedArray2 {
    public int findMin2(int [] num, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        
        while (start + 1 < end) {
            if (num[start] < num[end]) {
                return num[start];
            }
            
            int mid = start + (start + end) / 2;
            
            if (num[mid] > num[end] || num[mid] > num[start]) {
                start = mid + 1;
            } else if (num[mid] < num[start] || num[mid] < num[end]){
                end = mid;
            } else {
                return Math.min(findMin2(num, start, mid), findMin2(num, mid + 1, end));
            }
        }
        
        if (num[start] < num[end]) {
            return num[start];
        }
        return num[end];
        
    }
    
    
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        
        return findMin2(num, start, end);
    }
}
