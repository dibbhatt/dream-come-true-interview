package algorithm.string;

/**
 * Description : Implement strStr(). Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Source : Leetcode https://leetcode.com/problems/implement-strstr/
 * Created_By : xmpy
 * Time : Jul 12, 2016 8:14:06 PM  
 */
public class StrStr {
    public int strStrBurteForce(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int start = i;
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
            i = start;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        final int BASE = 127;
        final int MOD = 0x07FFFFFF;
        int powerS = 1;
        int hayBeforeMod = 0;
        int needleHash = 0;
        for (int i = 0; i < needle.length(); i++) {
        	powerS = i > 0 ? powerS * BASE : 1;
        	hayBeforeMod *= BASE;
        	hayBeforeMod += haystack.charAt(i);
            needleHash *= BASE;
            needleHash += needle.charAt(i);
        }
        needleHash = needleHash % MOD;
        int hayHash = hayBeforeMod % MOD;
        if (hayHash == needleHash && haystack.substring(0, needle.length()).equals(needle)) {
            return 0;
        }

        for (int i = needle.length(); i < haystack.length(); i++) {
        	hayBeforeMod -=  haystack.charAt(i - needle.length()) * powerS;
        	hayBeforeMod *= BASE;
        	hayBeforeMod += haystack.charAt(i);
            hayHash = hayBeforeMod % MOD;
            if (hayHash == needleHash && haystack.substring(i - needle.length() + 1, i + 1).equals(needle)) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
