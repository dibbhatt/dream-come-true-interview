package algorithm.string;

public class ReverseVowelsOfAString {
    private boolean isVowel(char c) {
    	c = Character.toLowerCase(c);
    	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
    
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0; 
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !isVowel(chars[i])) {
                i++;
            }
            while (i < j && !isVowel(chars[j])) {
                j--;
            }
            if (i < j && s.charAt(i) != s.charAt(j)) {
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
