package algorithm.math;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        
        while (i <= j) {
            if (!((num.charAt(i) == num.charAt(j) && (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8')) || (num.charAt(i) == '6' && num.charAt(j) == '9') || (num.charAt(i) == '9' && num.charAt(j) == '6'))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
