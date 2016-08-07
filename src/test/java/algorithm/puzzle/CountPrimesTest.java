package algorithm.puzzle;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountPrimesTest {
	
	@Test
	public void testCountPrimes() {
		CountPrimes cp = new CountPrimes();
		assertEquals(0, cp.countPrimesBruteForce2(2));
		cp = new CountPrimes();
		assertEquals(2, cp.countPrimesBruteForce2(4));
		assertEquals(2, cp.countPrimesSaveSpace(4));

		
	}
	
}
