package algorithm.dp;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-9 
 * Time : 下午4:58:05
 */
public class DecodeWays {
    public int numDecodings(String s) {

        int[] state = new int[s.length()+1];
        state[0] = 1;

        if (s.length() == 0){
            return 0;
        } 
        if (s.charAt(0) <= '9' && s.charAt(0) >= '1'){
            state[1] = 1;
        } else {
            return 0; //something error occurs!
        }
        
        for (int i = 2; i <= s.length(); i++){
            state[i] = 0;
            if (s.charAt(i - 1) <= '9' && s.charAt(i-1) >= '1'){
                state[i] += state[i-1];
            }
            
            if (isValid(s.charAt(i-2), s.charAt(i-1))){
                state[i] += state[i-2];
            }
        }

        return state[s.length()];
    }
    
    public boolean isValid(char first, char second){
        if (first == '1' && (second <= '9' && second >= '0')){
            return true;
        }
        if (first == '2' && (second <= '6' && second >= '0')){
            return true;
        }
        return false;
    }
}
