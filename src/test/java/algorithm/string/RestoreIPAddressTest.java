package algorithm.string;

import org.junit.Test;

public class RestoreIPAddressTest {
	@Test
	public void testRestoreIpAddress() {
		RestoreIPAddress r = new RestoreIPAddress();
		System.out.println(r.restoreIpAddresses("010010"));
		System.out.println(r.restoreIpAddresses("010010", 5));
	}
}
