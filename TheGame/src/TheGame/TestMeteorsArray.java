package TheGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMeteorsArray {
	@Test
	void test() {
		Meteors testMeteors=new Meteors();
		int [][] output = testMeteors.meteorDimension(5);
		assertTrue(output.length == Gameplay.level);
		assertTrue(output[0].length == 5*2);
	}
	void test2() {
		Meteors testMeteors2=new Meteors();
		int [][] output = testMeteors2.meteorDimension(10);
		assertTrue(output.length == Gameplay.level);
		assertTrue(output[0].length == 20);
	}
	
	void testMeteorArraylength() {
		Meteors testMeteors3=new Meteors();
		int [][] output = testMeteors3.meteorDimension(10);
		assertTrue(output.length > 0);
	}
}
