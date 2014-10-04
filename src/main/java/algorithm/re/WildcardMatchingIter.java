package algorithm.re;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 22, 2014 
 * Time : 5:14:51 PM
 */
public class WildcardMatchingIter {
	
	public boolean isMatch(String s, String p) {
		
		boolean[][] state = new boolean[p.length() + 1][s.length() + 1];
		boolean[] have = new boolean[s.length()+1];
		boolean[] have2 = new boolean[s.length()+1];
		
		state[p.length()][s.length()] = true;
		have[s.length()] = true;
		boolean pre = true;
		for (int i = s.length() - 1; i >= 0; i--){
			state[p.length()][i] = false; 
			have[i] = true;
		}
		
		for  (int j = p.length() - 1; j >=0; j--){
			if (p.charAt(j) == '*' && state[j + 1][s.length()]){
				state[j][s.length()] = true;
			} else {
				state[j][s.length()] = false;
			}
		}
		
		
		
		for (int i = p.length() - 1; i >= 0; i--) {
			char curr = p.charAt(i);
			for (int j = s.length() - 1; j >= 0; j--) {
				if (curr == '*'){
					state[i][j] = false;
					for (int k = j; k <= s.length(); k++){ //downward
						if (state[i+1][k] == true){
							state[i][j] = true;
							break;
						}
					}
				} else if (curr == '?'){
					state[i][j] = state[i + 1][j + 1];
				} else {
					if(p.charAt(i) == s.charAt(j)){
						state[i][j] = state[i+1][j+1];
					}else{
						state[i][j] = false;
					}
				}
			}
		
		}
		
		return state[0][0];
    }
	    
    @Test
    public void test(){
    	boolean r = isMatch("aa", "a*");
    	System.out.println(r);
    	
    	 r = isMatch("aa", "aa");
    	System.out.println(r);
    	
    	 r = isMatch("aa", "*");
    	System.out.println(r);
    	
    	r = isMatch("aab", "c*a*b");
    	System.out.println(r);
    	
    	r = isMatch("a", "*a*");
    	System.out.println(r);
    }
	
	
	
}
