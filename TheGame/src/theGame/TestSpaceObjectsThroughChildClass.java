package theGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSpaceObjectsThroughChildClass {
	
	@Test //createCluster method with 6 parameters
	void arrayCreated_isNotNull() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(0, 0, 0, 0, 0, 0);
		assertNotNull(createdCluster);
	}

	@Test //createCluster method with 6 parameters
	void xIsFiveYIsFour_createdArrayHasHeightFiveWidthFour() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(5, 4, 0, 0, 0, 0);
		assertEquals(5, createdCluster.length, "Expected lenght should be equal to the x parameter");
		assertEquals(4, createdCluster[0].length, "Expected height should be equal to thy y paramter");
	}

	@Test //createCluster method with 6 parameters
	void xPositionIsFive_elementZeroZeroOfArrayIsFive() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 5, 6, 0, 0);
		assertEquals( 5, createdCluster[0][0]);
	}

	@Test //createCluster method with 6 parameters
	void yPositionisFive_elementZeroOneOfArrayIsFive() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 6, 5, 0, 0);
		assertEquals(5, createdCluster[0][1]);
	}

	@Test //createCluster method with 6 parameters
	void xPositionisSixGapXIsFour_elementZeroTwoOfArrayIsTen() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 0);
		assertEquals(10, createdCluster[0][2]);
	}

	@Test //createCluster method with 6 parameters
	void yPositionIsFive_elementZeroThreeOfArrayIsFive() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertEquals(5, createdCluster[0][3]);
	}

	@Test //createCluster method with 6 parameters
	void xIsSixGapXisFour_elementOneZeroOfArrayIsEight() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertEquals(8, createdCluster[1][0]);
	}

	@Test //createCluster method with 6 parameters
	void yIsFiveGapYIsThree_elementOneOneOfArrayIsEight() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertEquals(8, createdCluster[1][1]);
	}

	@Test // Test createCluster method with 4 parameters
	void _arrayCreated_isNotNull() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(0, 0, 0, 0);
		assertNotNull(createdCluster);
	}

	@Test // Test createCluster method with 4 parameters
	void _xIsSixYIFive_createdArrayHasHeightSixWidthFive() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(6, 5, 0, 0);
		assertEquals(6, createdCluster.length, "Expected lenght should be equal to the x parameter");
		assertEquals(5, createdCluster[0].length, "Expected height should be equal to thy y paramter");
	}
	
	@Test // Test createCluster method with 4 parameters
	void createArray_evenPositionsAreWithinZeroAndOneThousandFiveHundrend() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 0, 0);	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j%2==0) assertTrue (createdCluster[i][j]>=0 && createdCluster[i][j]<=1500);
			}
		}
	}
	@Test // Test createCluster method with 4 parameters
	void createArray_oddPositionsAreWithinZeroAndEightHundrend() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 0, 0);	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j%2!=0) assertTrue (createdCluster[i][j]>=0 && createdCluster[i][j]<=800);
			}
		}
	}
	@Test // Test createCluster method with 4 parameters
	void gapLeftIsTwoHundrend_evenPositionsAreWithinTwoHundrendAndOneThousandFiveHundrend() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 200, 0);	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j%2==0) assertTrue (createdCluster[i][j]>=200 && createdCluster[i][j]<=1500);
			}
		}
	}
	@Test // Test createCluster method with 4 parameters
	void gapRightIsTwoHundrend_evenPositionsAreWithinZeroAndOneThousandThreeHundrend() {
		Meteors meteors = new Meteors();
		int[][] createdCluster = meteors.createCluster(10, 10, 0, 200);	
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j%2==0) assertTrue (createdCluster[i][j]>=0 && createdCluster[i][j]<=1300);
			}
		}
	}

}