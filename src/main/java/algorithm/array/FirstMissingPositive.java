package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-13 
 * Time : 下午8:59:53
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int[] Acopy = new int[A.length + 1];
        Acopy[0] = 0;
        for (int i = 0; i < A.length; i++) {
            Acopy[i + 1] = A[i];
        }
        Arrays.sort(Acopy);
        int pre = Acopy[0];
        for (int i = 1; i < Acopy.length; i++){
        	if (Acopy[i] == pre) {
        		continue;
        	}
            if (((pre + 1) > 0)&& Acopy[i] != pre + 1) {
                return pre + 1;
            }
            pre = Acopy[i];
        }
        return pre + 1;
    }
    
    public int firstMissingPositive2(int [] A) {
    	if (A.length == 0) {
    		return 1;
    	}
    	
    	HashSet<Integer> hs = new HashSet();
    	int r = 1;
    	for (int i = 0; i < A.length; i++) {
    		hs.add(A[i]);
    	}
    	
    	for (int i = 0; i < hs.size(); i++) {
    		if (!hs.contains(r)) {
    			return r;
    		} else {
    			r = r + 1;
    		}
    	}
    	
    	return r;
    }
    
    public int firstMissingPositiveBest(int[] A){
    	if (A.length == 0) {
    		return 1;
    	}
    	
    	for (int i = 0; i < A.length; i++) {

    		if (A[i] - 1 == i){
    			continue;
    		}
    		
    		int index = i;
    		while (A[index] > 0 && A[index] <= A.length) {
    			int temp = A[A[index] - 1];
    			
    			if (temp == A[index]){
    				break;
    			}
    			A[A[index] - 1] = A[index];
    			A[index] = temp;
    		}
    	}
    	

    	for (int i = 0; i < A.length; i++) {
    		System.out.println(A[i]);
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}
    	return A.length+1;
    }
    
    @Test
    public void test(){
    	int[] A = new int[]{1, 1};
    	System.out.println(firstMissingPositiveBest(A));
    }
}
