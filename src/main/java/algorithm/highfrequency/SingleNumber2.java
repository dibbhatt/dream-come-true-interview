package algorithm.highfrequency;
/** 
 * 每个数都有3个，只有一个数只有一个
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-12 
 * Time : 下午8:22:10
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < 32; j++){
                if ((A[i] >> j & 1) != 0){
                    bits[j] +=1;
                }
                
                if (bits[j] == 3){
                    bits[j] = 0;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++){
            if (bits[i] != 0)
                result |= 1 << i;
        }
        return result;
    }
}
