package theGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

abstract class SpaceObjects {

	protected int [][] createCluster(int x, int y, int xPosition, int yPosition, int gapX, int gapY){
		int startingX= yPosition;
		int clusterOfSpaceObjects[][]= new int [x][y];
			for (int i=0; i< x; i++) {
				for (int j=0; j<y; j++) {
					if (j%2==0)clusterOfSpaceObjects [i][j]=xPosition;
					else clusterOfSpaceObjects[i][j]=yPosition;
					xPosition+= gapX;
					}
					if (i%2==0) xPosition=startingX;
					else xPosition=startingX + gapX;	
				yPosition+=gapY;
			}
		return clusterOfSpaceObjects;
	}
	
	protected int [][] createCluster(int x, int y, int size){
		int clusterOfSpaceObjects[][]= new int [x][y];
			for (int i=0; i< x; i++) {
				for (int j=0; j<y; j++) {
					if (j%2==0)clusterOfSpaceObjects [i][j]=randomXposition(size);
					else clusterOfSpaceObjects[i][j]=randomYposition(size);
				}
		
			}
			return clusterOfSpaceObjects;
	}
	
	private int randomXposition(int size) {
		Random random = new Random();
		return random.nextInt(Main.getFrameX() - size - Gameplay.getShipStartingX() - + 1) + size +Gameplay.getShipStartingX();
	}

	private int randomYposition(int size) {
		Random random = new Random();
		return random.nextInt(Main.getFrameY() - size + 1) + size;
	}
	
	public void drawClusterofObjects (Graphics2D c, Color color, int [][] clusterOfSpaceObjects, int width, int height, boolean rectangle) {
		c.setColor(color);
		for (int j=0; j<clusterOfSpaceObjects.length; j++) {
			for (int i=0; i<clusterOfSpaceObjects[j].length-1; i+=2) {
				if (rectangle) {
				c.fillRect(clusterOfSpaceObjects[j][i], clusterOfSpaceObjects[j][i+1],width, height);
			}
				else c.fillOval(clusterOfSpaceObjects[j][i], clusterOfSpaceObjects[j][i+1],width, height);
			}
		}
	}
	
	public void spaceObjectFalls(int[][] positionArray, int gravity) {
		for (int i =0; i<positionArray.length; i++) {
			int [][] temporarypositionArray = positionArray;
			for (int k=0; k<positionArray[i].length; k++ ) {
					if (k%2!=0) {
						if (positionArray[i][k]> Main.getFrameY()) {
							temporarypositionArray[i][k]=0;
							positionArray = temporarypositionArray;
						}
						temporarypositionArray[i][k]+=gravity;
						positionArray = temporarypositionArray;
					}
			}
		}
	}
}

