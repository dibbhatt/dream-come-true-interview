package algorithm.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EncodeDecodeStringTest {

	@Test
	public void testEncodeDecode() {
		EncodeDecodeString ed = new EncodeDecodeString();
		List<String> input = new ArrayList<String>();
		input.add("hello");
		input.add("world");
		System.out.println(ed.decode(ed.encode(input)));
	}
}
