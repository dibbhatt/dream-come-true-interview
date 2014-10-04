package algorithm.search;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-30 
 * Time : 下午4:28:22
 */
public class NextPermutation {
    /**
     *	1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
     */
    public void nextPermutation(int[] num) {
    	//找到不逆序的第一个
    	int len = num.length;
    	if (num.length < 2)
    		return;
    	
    	int i = len - 2;
    	for(;i >= 0; i--){
    		if(num[i] < num[i+1]){
    			break;
    		}
    	}
    	// 如果一个都没找到
    	if (i == -1){
    		reverse(num, 0, len-1);
    		return;
    	}
    	
    	int j = len - 1;
    	for(; j > i; j--){
    		if (num[j] > num[i]){
    			int temp = num[j];
    			num[j] = num[i];
    			num[i] = temp;
    			break;
    		}
    	}
    	
    	reverse(num, i+1, len - 1);
    	return;
    }
    
    public void reverse(int[] num, int start, int end){
    	int iter_num = (end-start+1) / 2;
    	for(int i = 0; i < iter_num; i++){
    		int temp = num[end - i];
    		num[end-i] = num[start+i];
    		num[start+i] = temp;
    	}
    }
}
