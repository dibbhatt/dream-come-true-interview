package java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-17 
 * Time : 下午9:10:13
 */
public class SynchronizedMap<K, V> {
	
	private HashMap<K,V> hm = new HashMap<K, V>();
	
	public V get(K key){
		synchronized(hm) {
			return hm.get(key);
		}
	}
	
	
	public V put(K key, V value){
	
		synchronized(hm) {
			return hm.put(key, value);
		}
	}
	
	

	public void test(){
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		Map<Integer, String> m  = Collections.synchronizedMap(hm);
		Double d = new Double(0.01);	
	}
}
