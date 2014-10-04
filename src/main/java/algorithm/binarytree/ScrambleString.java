package algorithm.binarytree;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-20 
 * Time : 下午6:10:01
 * 
 * 
 */

/*
Second method: comes up with DP naturally
f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
            || f[k][i][j+n-k] && f[n-k][i+k][j]

*/
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        
        if (s1.length() == 1 || s1.equals(s2)){
            return true;
        }

        if (s1.length() == 2){
            if (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0)){
                return true;
            } else {
                return false;
            }
        }
        
        for (int i = 1; i < s1.length() - 1; i++){
            String s11 = s1.substring(0, i);
            String s21 = s2.substring(0, i);
            
            String s12 = s1.substring(i, s1.length());
            String s22 = s2.substring(i, s1.length());
            if (isValid(s11,s21)){
                if (isScramble(s11, s21) && isScramble(s12, s22)){
                    return true;
                }
            }
            s21 = s2.substring(s2.length() - i);
            s22 = s2.substring(0, s2.length() - i);
            
            if (isValid(s11,s21)){
                if (isScramble(s11, s21) && isScramble(s12, s22)){
                    return true;
                }
            }
            
            
        }
        
        return false;
    }
    
    public boolean isValid(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        String s11 = new String(arr1);
        String s22 = new String(arr2);
        
        if (s11.equals(s22)){
            return true;
        }
        return false;
    }
    
    public boolean isScramble2(String s1, String s2) {
        if( s1.length() != s2.length() ){
            return false;
        }
       
        if( s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
       
        if(! sorted_sequence(s1).equals(sorted_sequence(s2)))  // this could trim lots of uncessary recursion
            return false;
       
        for(int i = 1; i <= s1.length() - 1; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s31 = s2.substring(0, s2.length()-i);
            String s32 = s2.substring(s2.length() - i);

            if( (isScramble(s11, s21) && isScramble(s12, s22)) ||
                (isScramble(s11, s32) && isScramble(s12, s31)) ) {
                return true;
            }
        }
        return false;
    }
   
    private String sorted_sequence(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    @Test
    public void test(){
    	//boolean r = isScramble("great", "rgeat");
    	//System.out.println(r);
    	
    	boolean rr = isScramble2("tqxpxeknttgwoppemjkivrulaflayn", "afaylnlurvikjmeppowgttnkexpxqt");
    	System.out.println(rr);

    }
}
