package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

public class Meteors {
	private int wh = 40;

	//method that generates number between 60 and 1480, which is the Frame width
	public int ranX() {
		return ThreadLocalRandom.current().nextInt(70, 1480);
	}

	//method that generates number between 20 and 780, which is the Frame height
	public int ranY() {
		return ThreadLocalRandom.current().nextInt(20, 780);
	}
	// A method that generates a 2d Array with random X and Y values. Even positions in the arrays are X and positions are Y
	// The number of array depends on the level. 
	public int [][] meteorDimension(int meteorsperlevel){
		meteorsperlevel*=2;
		int [][] array = new int [Gameplay.level][meteorsperlevel];
		for (int i=0; i< Gameplay.level; i++) {
			for (int j=0; j<meteorsperlevel; j++) {
				if (j%2==0)array [i][j]=ranX();
				else array[i][j]=ranY();
			}
		}
		return array;
	}
	
	int [][] metXY= meteorDimension(5);

	// Loop that generates meteors. i= x position and i+1= y position
	public void drawMeteors (Graphics2D m) {
		m.setColor(Color.red);
		//level of the game determines how many MetXY arrays will be used and thus how many meteors will be drawn
		for (int j=0; j<Gameplay.level; j++) {
			for (int i=0; i<metXY[j].length-1; i+=2) {
			m.fillOval(metXY[j][i], metXY[j][i+1], wh, wh);
			}
		}
	}
}
	


