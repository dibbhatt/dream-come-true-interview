package algorithm.array;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-6-14 
 * Time : 下午11:22:11
 */
public class Strstr {
    public int strStr(String source, String target) {
        //write your code here
        for (int i = 0; i < source.length(); i++){
            int j = 0;
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i+j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
    @Test
    public static void main(String[] args){
    	Strstr s = new Strstr();
    	System.out.println(s.strStr("source", "target"));
    }
}
