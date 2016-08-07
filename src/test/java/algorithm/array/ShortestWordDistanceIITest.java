package algorithm.array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ShortestWordDistanceIITest {
	@Test
	public void testShortest() {
		String[] arr = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistanceII sd = new ShortestWordDistanceII(arr);
		assertEquals(3, sd.shortest("coding", "practice"));
	}

}
