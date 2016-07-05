package algorithm.dp;

import org.junit.Test;

/** 
 * Description : You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Source : https://leetcode.com/problems/coin-change/
 * Created_By : zhaoxm (xmpy) 
 * Date : Mar 20, 2016 
 * Time : 10:23:13 PM
 */
public class CoinChange {
	/*
	 * 1. State: state[i, j] represents the fewest number of first i + 1 kinds of coins to make up j amount of money.
	 * 2. Transfer Equation: state[i, j] = Min(state[i - 1, j], state[i][j-v_i] + 1) 
	 * 3. Initialization: state[i][j] = -1; state[i][0] = 0;
	 * 4. Answer: state[N-1][V] N is the number of kinds of coin value, V is the target money amout. 
	 */
    public int coinChange(int[] coins, int amount) {
    	if (amount < 0) {
    		return -1;
    	}
    	int n = coins.length;
    	int[] state = new int[amount + 1];
    	state[0] = 0;
    	for (int i = 1; i < state.length; i++) {
    		state[i] = -1; // No way
    	}
    	for (int i = 0; i < n; i++) {
    		for(int j = coins[i]; j <= amount; j++) {
    			if (state[j] == -1 && state[j - coins[i]] == -1) {
    				state[j] = -1;
    			} else if (state[j] == -1) {
    				state[j] = state[j - coins[i]] + 1;
    			} else if (state[j - coins[i]] == -1) {
    				// do nothing; state[j] = state[j];
    			} else {
    				state[j] = Math.min(state[j], state[j - coins[i]] + 1);
    			}
    		}
    	}
    	
        return state[amount];
    }
    
    @Test
	public  void tests() {
    	CoinChange cc = new CoinChange();
    	int[] coins = new int[] {1,2,5};
    	int amount =11 ;
    	System.out.println(cc.coinChange(coins, amount));    	
    }
}
