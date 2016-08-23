package algorithm.array;
/** 
 * Description :
 * Source : http://www.practice.geeksforgeeks.org/problem-page.php?pid=700274
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 23, 2016 
 * Time : 10:48:11 PM
 */
public class FindKthElementInSpiralFormOfMatrix {
    int findK(int A[][], int n, int m, int k) {
    	int nn = n;
    	int mm = m;
    	int kk = k;
    	//For each circle
    	int offset = 0;
    	for (offset = 0; offset < Math.min(n, m) / 2; offset++) {
    		if ( kk <= 2*nn + 2 *mm - 4 ) {
    			if ( kk <= mm) {
    				return A[offset][offset + kk - 1];
    			} else if (kk <= mm + nn - 1) {
    				return A[offset + kk - mm][m - offset - 1];
    			} else if (kk <= mm + nn - 1 + mm - 1) {
    				return A[n - offset - 1][m - offset - 1 - (kk - mm - nn + 1)];
    			} else {
    				return A[offset + 2*nn + 2 *mm - 4 - kk][offset];
    			}
    		}
    		
    		kk -= 2*nn + 2 *mm - 4;
    		nn -= 2;
    		mm -= 2;
    		
    	}
    	
    	// Out of Range
    	if (Math.min(n, m) % 2 == 0) {
    		return -1;
    	}
    	
    	// Horizontal
    	if (n < m ) {
    		if (kk > mm) {
    			return -1;
    		}
    		return A[offset][offset + kk - 1];
    	} 
    	
    	if (kk > nn) {
    		return -1;
    	}
    	return A[offset + kk - 1][offset];
    	
    }
}
