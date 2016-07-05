package algorithm.string;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jun 9, 2015 
 * Time : 9:37:33 PM
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class NumComparator implements Comparator<String> {
    public int compare(String a, String b) {
        int n = a.length() < b.length() ? a.length() : b.length();
        
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return 1;
            }
            if (a.charAt(i) > b.charAt(i)) {
                return -1;
            }
            
        }
        return 0;
    }
}



public class LargestNumber {
    public String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<String>();
        for (int n:nums) {
            list.add((new Integer(n)).toString());
        }
        Collections.sort(list, new NumComparator());
        StringBuffer sb = new StringBuffer();
        for (String s: list) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}