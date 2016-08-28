package algorithm.string;

import org.junit.Test;

public class CombinePhoneNumberTest {

	@Test
	public void testLetterCombinations() {
		CombinePhoneNumber cpn = new CombinePhoneNumber();
		cpn.letterCombinations("2");
		
		CombinePhoneNumber2 cpn2 = new CombinePhoneNumber2();
		System.out.println(cpn2.letterCombinations("1"));
	
		CombinePhoneNumber3 cpn3 = new CombinePhoneNumber3();
		System.out.println(cpn3.letterCombinations("2"));
	}
	
}
