package theGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCreateClusterThroughChildMeteors {

	@Test
	void createCluster_Array_is_notNull() {
		Meteors meteors = new Meteors();
			int [][] createdCluster = meteors.createCluster(0, 0, 0, 0, 0, 0);
			assertTrue(createdCluster != null);
		}
	@Test
	void createCluster_x_andy_are_define_arrays_length() {
		Meteors meteors = new Meteors();
			int [][] createdCluster = meteors.createCluster(10, 10, 0, 0, 0, 0);
			boolean right_Lengths= createdCluster.length==10 && createdCluster[0].length==10 ;
			assertTrue(right_Lengths);
		}
	@Test
	void creatCluster_firstArrayposition_hasValueOf_PositionX(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 5, 6, 0, 0);
		assertTrue( createdCluster[0][0]==5);
	}
	@Test
	void creatCluster_secondArrayposition_hasValueOf_PositionY(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 6, 5, 0, 0);
		assertTrue( createdCluster[0][1]==5);
	}
	@Test
	void creatCluster_thirdArrayposition_hasValueOf_PositionX_plus_GapX(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 0);
		assertTrue( createdCluster[0][2]==10);
	}
	@Test
	void creatCluster_fourthArrayposition_hasValueOf_PositionY(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertTrue( createdCluster[0][3]==5);
	}
	void creatCluster_firstArraypositionOf_Secondlevel_hasValueOf_PositionxPlusGapXdividedBy2(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertTrue( createdCluster[1][0]==13);
	}
	
	void creatCluster_secondArraypositionOf_Secondlevel_hasValueOf_PositionYPlusGapY(){
		Meteors meteors = new Meteors();
		int [][] createdCluster = meteors.createCluster(10, 10, 6, 5, 4, 3);
		assertTrue( createdCluster[1][1]==8);
	}
	
}


