package algorithm.array;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-13 
 * Time : 上午12:29:47
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int kk = (A.length + B.length)/2;

        if((A.length + B.length)%2 == 0){
        	
        	System.out.println(findKth(A,B,kk));
        	System.out.println(findKth(A,B,kk+1));
            return (findKth(A,B,kk)+findKth(A,B,kk+1))/2.0;
        }
        return findKth(A,B,kk+1);
        
    }
    
    public int findKth(int A[], int B[], int k){
        int aStart = 0;
        int bStart = 0;
        
        
        while(aStart != A.length && bStart != B.length && k > 1){
            int aStep = k/2 - 1;
            int bStep = k - k/2 - 1;

            
            if((aStart + aStep) >= A.length)
                aStep = A.length - 1 - aStart;
            
            if((bStart + bStep) >= B.length)
                bStep = B.length - 1 - bStart; 
                
            if(A[aStart + aStep] < B[bStart + bStep]){
                aStart = aStart + aStep + 1;
                k -= aStep + 1;
            }else if(A[aStart + aStep] > B[bStart + bStep]){
                bStart = bStart + bStep + 1;
                k -= bStep + 1;
            }else{
                aStart = aStart + aStep;
                k -= aStep + 1;
            }
        
        }
        if(k == 1 && aStart != A.length && bStart != B.length)
        	return A[aStart] < B[bStart] ? A[aStart]:B[bStart];
        	
        if(aStart == A.length){
            return B[bStart + k-1];
        }else 
            return A[aStart + k-1];
    }
    public static void main(String[] args){
    	MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
    	System.out.println(m.findMedianSortedArrays(new int[]{1,3,4}, new int[]{2}));
    }
    
}
