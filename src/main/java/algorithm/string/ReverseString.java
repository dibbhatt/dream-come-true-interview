package algorithm.string;

public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0; 
        int j = chars.length - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            i++;
            j--;
        }
        return new String(chars);
    }
}
