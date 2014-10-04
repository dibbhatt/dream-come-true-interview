package algorithm.binarysearch;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-12 
 * Time : 下午1:19:36
 */
public class SearchARange {
    public int[] searchRange(int[] A, int target) {
        
        int left = searchStart(A, target);
        int right = searchEnd(A, target);
        int [] result = {left,right};
        return result;
        
    }
    
    
    public int searchStart(int[] A, int target){
        if(A.length == 0)
            return -1;
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = (start + end) /2;
            if(A[mid] == target){
                end = mid;
            }else if(A[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(A[start] == target)
            return start;
        if(A[end] == target)
            return end;
          return -1;
      }
      
      public int searchEnd(int[] A, int target){
          if(A.length == 0)
              return -1;
          int start = 0;
          int end = A.length - 1;
          
          while(start + 1 < end){
              int mid = (start + end) /2;
              if(A[mid] == target){
                  start = mid;
              }else if(A[mid] < target){
                  start = mid + 1;
              }else{
                  end = mid - 1;
              }
          }
          if(A[end] == target)
              return end;
          if(A[start] == target)
              return start;
          return -1;
      }
}
