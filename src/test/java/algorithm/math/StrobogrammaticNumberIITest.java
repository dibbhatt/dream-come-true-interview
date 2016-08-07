package algorithm.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.math.StrobogrammaticNumberII;

public class StrobogrammaticNumberIITest {
	@Test
	public void testFindStrobogrammatic() {
		StrobogrammaticNumberII sn2 = new StrobogrammaticNumberII(); 
		System.out.println(sn2.findStrobogrammatic(8));
	}
}