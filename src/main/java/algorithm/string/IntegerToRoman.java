package algorithm.string;

public class IntegerToRoman {
	public String getNormalString(int n) {
		switch (n) {
		case 1:
			return "I";
		case 5:
			return "V";
		case 10:
			return "X";
		case 50:
			return "L";
		case 100:
			return "C";
		case 500:
			return "D";
		case 1000:
			return "M";
		default:
			return "No such number";
		}
	}

	public String intToRoman(int num) {
		String result = "";
		int qian = num / 1000;
		if (qian != 0) {
			for (int i = 0; i < qian; i++)
				result += getNormalString(1000);
		}
		num -= qian * 1000;

		for (int k = 2; k >= 0; k--) {
			int c = (int) (Math.pow(10, k));
			int bai = num / c;
			if (bai != 0) {
				if (bai == 4)
					result += getNormalString(c) + getNormalString(5 * c);
				else if (bai < 4) {
					for (int i = 0; i < bai; i++)
						result += getNormalString(c);
				} else if (bai == 5) {
					result += getNormalString(5 * c);
				} else if (bai == 9) {
					result += getNormalString(c) + getNormalString(c * 10);
				} else {
					result += getNormalString(5 * c);
					for (int i = 6; i < bai + 1; i++) {
						result += getNormalString(c);
					}
				}
			}
			num -= bai * c;
		}

		return result;
	}
}
