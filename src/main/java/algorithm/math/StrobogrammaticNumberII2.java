package algorithm.math;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StrobogrammaticNumberII2 {
	private static final String[] n1 = new String[]{"0", "1", "8"};
	private static final String[] n2 = new String[]{"00", "11", "88", "69", "96"};

    public List<String> findStrobogrammatic(int n) {
    	List<String> res = new LinkedList<String>();
    	String[] bases = n2;
    	if (n % 2 == 1) {
    		bases = n1;
    	}
    	List<String> pres = new LinkedList<String>();
    	pres.addAll(Arrays.asList(bases));
    	List<String> currs = new LinkedList<String>();
    	for (int i = 0; i < (n - 1) / 2; i++) {
    		for (String pre : pres) {
    			currs.add("0" + pre + "0");
    			currs.add("1" + pre + "1");
    			currs.add("8" + pre + "8");
    			currs.add("6" + pre + "9");
    			currs.add("9" + pre + "6");
    		}
    		pres = currs;
    		currs = new LinkedList<String>();
    	}
    	
    	if (n != 1) {
    		for (Iterator<String> iter = pres.listIterator(); iter.hasNext(); ) {
    		    String a = iter.next();
    		    if (a.startsWith("0")) {
    		        iter.remove();
    		    }
    		}
    	}
    	return pres;
    }
}
