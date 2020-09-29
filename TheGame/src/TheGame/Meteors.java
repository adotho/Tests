package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Meteors {
	private int size = 40;
	int [][] allMeteors= meteorDimension(5);


	//method that generates number between 60 and 1480, which is the Frame width
	private int randomXMeteor() {
		Random random = new Random();
		return random.nextInt(Main.frameX - size + 1) + size;
	}

	//method that generates number between 20 and 780, which is the Frame height
	private int randomYMeteors() {
		Random random = new Random();
		return random.nextInt(Main.frameY - size + 1) + size;
	}
	// A method that generates a 2d Array with random X and Y values. Even positions in the arrays are X and odd positions are Y
	// The number of array depends on the level. 
	private int [][] meteorDimension(int meteorsperlevel){
		meteorsperlevel*=2;
		int [][] array = new int [Gameplay.getLevel()][meteorsperlevel];
		for (int i=0; i< Gameplay.getLevel(); i++) {
			for (int j=0; j<meteorsperlevel; j++) {
				if (j%2==0)array [i][j]=randomXMeteor();
				else array[i][j]=randomYMeteors();
			}
		}
		return array;
	}	
		public void drawMeteors (Graphics2D m) {
		m.setColor(Color.red);
		//level of the game determines how many MetXY arrays will be used and thus how many meteors will be drawn
		for (int j=0; j<Gameplay.getLevel(); j++) {
			for (int i=0; i<allMeteors[j].length-1; i+=2) {
			m.fillOval(allMeteors[j][i], allMeteors[j][i+1], size, size);
			}
		}
	}
}
	


