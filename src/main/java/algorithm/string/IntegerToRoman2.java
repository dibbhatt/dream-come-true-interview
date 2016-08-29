package algorithm.string;

public class IntegerToRoman2 {
	public String intToRoman(int num) {
		int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < value.length; i++) {
			int count = num / value[i];
			num = num % value[i];
			for (int j = 0; j < count; j++) {
				sb.append(symbol[i]);
			}
		}
		return sb.toString();
	}
}
