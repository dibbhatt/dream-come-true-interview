package algorithm.highfrequency;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-8 
 * Time : 下午8:48:26
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        
        int start = 0; int end = s.length() - 1;
        
        while (start < end) {
            while (start < end && !(isValid(s.charAt(start)))) {
                start++;
            }
            while (start < end && !(isValid(s.charAt(end)))){
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }

    public boolean isValid(char a) {
        if ((a <= 9 && a >= 0) || (a <= 'z' && a >= 'a') || (a <= 'Z' && a >= 'A')) {
            return true;
        }
        return false;
    }
}
