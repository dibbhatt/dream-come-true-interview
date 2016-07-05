package algorithm.highfrequency;

import java.util.Arrays;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-8 
 * Time : 下午4:08:54
 */
public class CandyClear {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        int r = 0;
        for (int i = 0; i < candies.length; i++){
            r += candies[i];
        }
        return r;
    }
}
