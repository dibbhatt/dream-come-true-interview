package algorithm.array;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1,  String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] r = new int[num1.length() + num2.length()];
        
        Arrays.fill(r, 0);
        
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--) {
            	int numi = num1.charAt(i) - '0';
            	int numj = num2.charAt(j) - '0';

                int sum = r[i + j + 1] + carry + numi * numj;
                r[i + j + 1] = sum % 10;
                carry = sum / 10;
            }
            if (carry != 0) {
                r[i] = carry;
            }
        }
        
        int i = 0; 
        for (; i < len1 + len2; i++) {
            if (r[i] != 0) {
                break;
            }
        }
        if (i == (len1 + len2)){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int j = i; j < len1 + len2; j++ ){
            sb.append(r[j]);
        }
        return sb.toString();
    }
}
