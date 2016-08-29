package algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> r = new ArrayList<String>();
		int k = 4;
		helper(s, 0, new int[k - 1], r);
		return r;
	}

	public List<String> restoreIpAddresses(String s, int k) {
		List<String> r = new ArrayList<String>();
		helper(s, 0, new int[k - 1], r);
		return r;
	}
	
	private boolean isValidPart(String s) {
		if (s.length() > 1 && s.startsWith("0")) {
			return false;
		}
		int part = Integer.parseInt(s);
		if (part >= 0 && part <= 255) {
			return true;
		}
		return false;
	}

	private String render(String s, int[] dots) {
		int preIdx = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dots.length; i++) {
			sb.append(s.substring(preIdx, dots[i] + 1)+ ".");
			preIdx = dots[i] + 1;
		}
		sb.append(s.substring(preIdx, s.length()));
		return sb.toString();
	}

	public void helper(String s, int already, int[] dots, List<String> result) {
		// last dot
		int preIdx = (already == 0) ? -1 : dots[already - 1];
		if (already == dots.length - 1) {
			for (int i = preIdx + 1; i <= preIdx + 3 && i < s.length() - 1; i++) {
				// make sure that the last part length less than 3
				if (i + 1 < s.length() - 3) {
					continue;
				}
				if (isValidPart(s.substring(preIdx + 1, i + 1))
						&& isValidPart(s.substring(i + 1, s.length()))) {
					dots[already] = i;
					String res = render(s, dots);
					result.add(res);
				}
			}
			return;
		}

		for (int i = preIdx + 1; i <= preIdx + 3
				&& i < s.length() - (dots.length - already); i++) {
			if (isValidPart(s.substring(preIdx + 1, i + 1))) {
				dots[already] = i;
				helper(s, already + 1, dots, result);
			}
		}
	}

}
