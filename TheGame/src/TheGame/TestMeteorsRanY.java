package TheGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMeteorsRanY {

	@Test
	void test() {
		Meteors testMeteors= new Meteors();
		int output = testMeteors.ranY();
		boolean Yrange = (testMeteors.ranY() > 0 && testMeteors.ranY()< Main.fY);
		assertTrue(Yrange);
	}

}
