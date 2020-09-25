package unitests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountAtest {

	@Test
	public void test() {
		CountA countAtest= new CountA();
		int output= countAtest.findA("lalalA");
		assertEquals(3, output);
	}

}
