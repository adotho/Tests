package TheGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMeteorsRanX {

	@Test
	void test() {
		Meteors testMeteors= new Meteors();
		int output = testMeteors.ranX();
		boolean Xrange = (testMeteors.ranX() > 0 && testMeteors.ranX()< Main.fX);
		assertTrue(Xrange);
	}

}
