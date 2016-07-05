package algorithm.heap;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Description : 给一堆point(x, y), 返回前k个离远点最近的点,
 *  用k-selection算法, 核心就是那个partition, 平均时间复杂度可以做到O(n).
 * Source : Facebook 面试题
 *          非常好的解释：http://xinpeng.me/?p=607
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-5 
 * Time : 下午1:46:30
 */
public class TopKBySelectK {
	void swap(int[] a, int ind1, int ind2) {
		int temp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = temp;
	}
	
	
	int partition(int[] a, int start, int end) {
		if (start == end) {
			return start;
		}
		
		int pivot = a[start];
		
		while (start < end) {
			while (start < end && a[end] >= pivot) {
				end--;
			}
			swap(a, start, end);
			
			while (start < end && a[start] <= pivot) {
				start++;
			}
			swap(a, start, end);
		}
		return start;	
	}
	
	// 找到第Top K个元素
    int selectKth(int[] a, int start, int end, int k) {
        if (start == end) {
            return a[start];
        }
        int pivotIdx = partition(a, start, end); 
        
        int q = pivotIdx - start + 1;
        if (q == k) {
            return a[pivotIdx];
        }
        if (q > k) {
            return selectKth(a, start, pivotIdx - 1, k);
        }
        
        return selectKth(a, pivotIdx + 1, end, k - q);
    }
    
    // 找到TOP K个元素    
    ArrayList<Integer> ret = new ArrayList<Integer>();
    
    void selectK (int[] a, int start, int end, int k) {
        if (start == end) {
            ret.add(a[start]);
        }
        
        int pivotIdx = partition(a, start, end);
        int q = pivotIdx - start + 1;
        if (q == k) {
        	for (int i = start; i <= pivotIdx; i++) {
        		ret.add(a[i]);
        	}
        	return;
        }
        
        if (q < k) {
        	for (int i = start; i <= pivotIdx; i++) {
        		ret.add(a[i]);
        	}
        	selectK(a, pivotIdx + 1, end, k - q);
        	
        } else {
        	
        	selectK(a, start, pivotIdx - 1, k);
        }
        
    
    }

    
    @Test
    public void test() {
    	int[] a = new int[] {3,2,4,6,1,32,4,2,-1,3,213};
    	System.out.println(selectKth(a, 0, a.length - 1, 6)); //Expect 6
    	
    	
    	selectK(a, 0, a.length - 1, 8);
    	System.out.println(ret);
    }

}
