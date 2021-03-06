package algorithm.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfitNoLimitedK(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }    
        return maxProfit;
    }
    
    public int maxProfitBruteForce(int k, int[] prices) {
        if ( k >= (prices.length / 2)) {
           return maxProfitNoLimitedK(prices);
        }
        
        int[][]  states = new int[prices.length + 1][k + 1];
        Arrays.fill(states[0], 0);
        
        for (int i = 0; i <= prices.length; i++) {
            states[i][0] = 0;
        }
        
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                states[i][j] = states[i - 1][j];   
                for (int x = 1; x < i; x++) {
                    int diff = prices[i - 1] - prices[x - 1];
                    states[i][j] = Math.max(states[i][j], states[x - 1][j - 1] + diff);   
                }
            }
        }
        return states[prices.length][k];
    }
    
    public int maxProfit(int k, int[] prices) {
        if ( k >= (prices.length / 2)) {
            return maxProfitNoLimitedK(prices);
         }
         
         int[][]  states = new int[prices.length + 1][k + 1];
         int[][]  locals = new int[prices.length + 1][k + 1];
         Arrays.fill(states[0], 0);
         Arrays.fill(locals[0], 0);

         for (int i = 0; i <= prices.length; i++) {
             states[i][0] = 0;
             locals[i][0] = 0;
         }
         for (int i = 1; i <= prices.length; i++) {
             int diff = (i == 1) ? 0 : (prices[i - 1] - prices[i - 2]);
        	 for (int j = 1; j <= k; j++) {
            	 locals[i][j] = Math.max(locals[i - 1][j] + diff, states[i - 1][j - 1] + diff);
                 states[i][j] = Math.max(locals[i][j], states[i - 1][j]);   
             }
         }
         
         return states[prices.length][k];
    }
    
    public int maxProfitSaveSpace(int k, int[] prices) {
        if ( k >= (prices.length / 2)) {
            return maxProfitNoLimitedK(prices);
         }
         
         int[]  states = new int[k + 1];
         int[]  locals = new int[k + 1];

         Arrays.fill(states, 0);
         Arrays.fill(locals, 0);

         for (int i = 1; i <= prices.length; i++) {
             int diff = (i == 1) ? 0 : (prices[i - 1] - prices[i - 2]);
        	 for (int j = k; j >= 1; j--) {
            	 locals[j] = Math.max(locals[j] + diff, states[j - 1] + diff);
                 states[j] = Math.max(locals[j], states[j]);   
             }
         }
         
         return states[k];
    }
}
