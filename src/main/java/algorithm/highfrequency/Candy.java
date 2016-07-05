package algorithm.highfrequency;

import java.util.Arrays;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-8 
 * Time : 下午2:08:50
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 0);
        
        if (ratings[0] < ratings[1]) {
            candies[0] = 1;
        }
        
        if (ratings[ratings.length - 1] < ratings[ratings.length - 2]) {
            candies[ratings.length - 1] = 1;
        }
        
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] <= ratings[i + 1] && ratings[i] <= ratings[i - 1]) {
                candies[i] = 1;
            } else if (ratings[i] == ratings[i - 1]) {
                candies[i] = candies[i - 1];
            } else if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 2; i > 0; i--) {
            if (ratings[i] == ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1]);
            } else if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        int r = 0;
        for (int i = 0; i < candies.length; i++){
        	if (candies[i] == 0) r += 1;
        	else {
        		r += candies[i];
        	}
        }
        return r;
    }
}
