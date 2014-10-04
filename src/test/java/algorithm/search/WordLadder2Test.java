package algorithm.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-6 
 * Time : 上午1:25:16
 */
public class WordLadder2Test {
	WordLadder2 wl2 = new WordLadder2();
	
	@Test
	public void testfindLadders(){
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		//dict.add("hit");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> result = wl2.findLadders(start, end, dict);
		System.out.println(result);
	}
		
}
