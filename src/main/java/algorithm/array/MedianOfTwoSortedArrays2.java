package algorithm.array;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-13 
 * Time : 下午4:44:23
 */
public class MedianOfTwoSortedArrays2 {
    public int findKth(int A[], int B[], int aStart, int bStart, int k){
    	
    	//System.out.println(aStart + "\t" + bStart + "\t"+ k);
        if(aStart == A.length){
            return B[bStart + k-1];
        }
        if(bStart == B.length){
            return A[aStart + k-1];
        }
        
        //the stop point
        
        if(k ==1){
            return Math.min(A[aStart], B[bStart]);        
        }
    
        if(aStart+ k/2 - 1 >= A.length){
            return findKth(A, B, aStart, bStart + (k/2), k - k/2);
        }
        
        if(bStart + k/2 - 1 >= B.length){
            return findKth(A,B, aStart + (k/2), bStart, k - k/2);
        }
        
        int aVal = A[aStart + k/2 -1];
        int bVal = B[bStart + k/2 -1];
        if(aVal < bVal){
            return findKth(A,B, aStart + (k/2), bStart, k - k/2);
        }else{
            return findKth(A,B, aStart, bStart + (k/2), k - k/2);
        }
        
    }
    public static void main(String[] args){
    	MedianOfTwoSortedArrays2 m = new MedianOfTwoSortedArrays2();
    	System.out.println(m.findKth(new int[]{1,3,4}, new int[]{2},0,0,3));
    }
}
