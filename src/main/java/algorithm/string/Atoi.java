package algorithm.string;
/** 
 * Description : Implement atoi to convert a string to an integer.
 * Source : https://oj.leetcode.com/problems/string-to-integer-atoi/
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-4 
 * Time : 下午3:22:33
 */
public class Atoi {
	/* Tips for atoi
	 * (1) Remove the leading and tailing whitespaces (Using str.trim() in Java)
	 * (2) The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
	 * (3) If no conversion is valid, a zero value is returned
	 * (4) If the correct value is out of the range of values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
	 * 
	 */
	
    public int atoi(String str) {
    	int r = 0;
    	str = str.trim();
    	if (str.length() == 0){
    		return 0;
    	}
    	int index = 0;
    	int sign = 1;
    	if (str.charAt(index) == '-') {
    		index++;
    		sign = -1;
    	} else if (str.charAt(index) == '+') {
    		index++;
    	}
    	
    	long num = 0;
    	for (int i = index; i < str.length(); i++){
    		char curr = str.charAt(i);
    		if (curr > '9' || curr < '0') {
    			break; //stop
    		}
    		
    		num = num * 10 + (curr - '0');
    		if (sign == 1 && num > Integer.MAX_VALUE) {
    			return Integer.MAX_VALUE;
    		} 
    		if (sign == -1 && num > - (long)Integer.MIN_VALUE) {
    			return Integer.MIN_VALUE;
    		}
    	}
    	return sign * (int)num;
    }

}
