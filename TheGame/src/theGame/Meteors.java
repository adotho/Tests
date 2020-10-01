package theGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Meteors extends SpaceObjects {
	private int size = 40;
	private int meteorsPerLevel = 5;
	private int meteorsPerLevelXYPositions = meteorsPerLevel*2;

	private int [][] allMeteors= createCluster(Gameplay.getLevel(), meteorsPerLevelXYPositions, size);
	
	public int getSize() {
		return size;
	}
	
	public int[][] getAllMeteors() {
		return allMeteors;
	}
	
	public void setAllMeteors(int[][] allMeteors) {
		this.allMeteors = allMeteors;
	}
}
	


