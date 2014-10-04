package algorithm.highfrequency;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-16 
 * Time : 上午10:57:54
 */
public class Sqrt {
    public int sqrt(int x) {
        if (x == 0){
            return 0;
        }
        
        if (x == 1){
            return 1;
        }
        long start = 1; 
        long end = x / 2;
        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            long value = mid * mid;
            if (value == x){
                return (int)mid;
            }
            if (value < x){
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        if (end * end <= x){
            return (int)(end);
        }
        return (int)(start);
    }
}
