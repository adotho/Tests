package unitests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCountAJupiter {

	@Test
	public void test() {
		CountA countAtest= new CountA();
		int output= countAtest.findA("lalalA");
		assertEquals(3, output);
	}
}
