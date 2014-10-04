package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-29 
 * Time : 下午9:39:39
 */
public class Sudoku {
	
	public boolean isValid(int in) {
		if (in > 9 || in <= 0) {
			return false;
		}
		return true;
	}
	
	
    public boolean isValidSudoku(int[] arr) {
        
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> hm = new HashSet<Integer>();
            HashSet<Integer> hm2 = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
            	int temp = get(arr, i, j);
            	if (!isValid(temp)) {
            		return false;   
            	}
            	
                if (!hm.contains(get(arr, i, j))) {
                	hm.add(get(arr, i, j));
                }                
                else {
                	return false;
                }
                temp = get(arr, j, i);
            	if (!isValid(temp)) {
            		return false;   
            	}
                
                if (!hm2.contains(get(arr, j, i))) {
                	hm2.add(get(arr, j, i));
                }                
                else {
                	return false;
                }
            }
            hm.clear();
            hm2.clear();
        }
        
        
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		HashSet<Integer> hm = new HashSet<Integer>();
        		for (int k = 0; k < 9; k++) {
        			int temp = get(arr, i * 3 + k / 3, j * 3 + k % 3);
                    if (!hm.contains(temp)) {
                    	hm.add(temp);
                    }                
                    else {
                    	return false;
                    }
        		}
        		hm.clear();
        	}
        	
        }
        return true;
    }
    
    
    public int get(int[] arr, int x, int y) {
        return arr[x*9 + y];
    }
}
