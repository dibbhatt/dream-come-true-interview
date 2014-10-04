package algorithm.re;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-2 
 * Time : 下午5:04:27
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayList<String> arr= new ArrayList<String>();
         
        String[] paths = path.split("/+");
        
        for (String p : paths) {
            if (p.equals("")){
                continue;
            }
            if (p.equals(".")){
                continue;
            } 
            if (p.equals("..")){
            	if (arr.size() == 0){
            		//arr.add("");
            	} else {
            		arr.remove(arr.size() - 1);
            	}
            } else {
                arr.add(p);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(arr.size() == 0) {
        	return "/";
        }
        
        for (String p : arr) {
            
            sb.append("/" + p);
        }
        return sb.toString();
    }

	
	@Test
	public void test(){
		String path = "/a/./b/..//../c/";
		String[] r = path.split("/");
		for (String t : r) {
			System.out.println(t);
		}
		System.out.println("********************************************");
		String path2 = "/a/./b/..//../c/";
		String[] rr = path2.split("/+");
		for (String t : rr) {
			System.out.println(t);
		}
		System.out.println("********************************************");

		String rrr = simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///");
		System.out.println(rrr);
		
	}

}



