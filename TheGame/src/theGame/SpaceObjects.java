package theGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * methods shared by SpaceObjects.
 * They are use for objects which appear more than once
 * 
 *
 * * @author Antonia
 *
 */
 abstract class SpaceObjects {
/**
 * Creates 2D array with XY values for ordered zig zag Space objects 
 * @param x = array length (number of clusters)
 * @param y = array[] length (XYPositions of SpaceObjects).
 * @param xPosition = horizontal position in Panel
 * @param yPosition = vertical position in Panel
 * @param gapX = horizontal distance between SpaceObjects 
 * @param gapY = vertical distance between SpaceObjects
 * @return Array with XY values. Each %==0 position in array contains X position, while %!=0 have Y positions
 */
	protected int [][] createCluster(int x, int y, int xPosition, int yPosition, int gapX, int gapY){
		int startingX= xPosition;
		int clusterOfSpaceObjects[][]= new int [x][y];
			for (int i=0; i< x; i++) {
				for (int j=0; j<y; j++) {
					if (j%2==0) {
						clusterOfSpaceObjects [i][j]=xPosition;
						xPosition+= gapX;
					}
					else clusterOfSpaceObjects[i][j]=yPosition;
					}
					if (i%2==0) xPosition=startingX + gapX/2;
					else xPosition=startingX;
					yPosition+=gapY;
			}
		return clusterOfSpaceObjects;
	}
	/**
	 * Returns 2D array with XY values for randomly flying Space objects
	 * by using the methods randomXposition and randomYposition
	 * @param x = Array.length
	 * @param y = Array[].length
	 * @param GapLeft distance from frame left borders
	 * @param GapRight distance from frame right borders
	 *  
	 * @return 2DArray
	 */
	protected int [][] createCluster(int x, int y, int GapLeft, int GapRight){
		int clusterOfSpaceObjects[][]= new int [x][y];
			for (int i=0; i< x; i++) {
				for (int j=0; j<y; j++) {
					if (j%2==0)clusterOfSpaceObjects [i][j]=randomXposition(GapLeft, GapRight);
					else clusterOfSpaceObjects[i][j]=randomYposition();
				}
		
			}
			return clusterOfSpaceObjects;
	}
	/**
	 * Method to generate random X position within the Gameframe
	 * @param min Minimum Value of X
	 * @param toBededutedFromMax Number to be deducted from Maximum, which is 1500 (the FrameWidth) 
	 * @return random integer within a range
	 */
	private int randomXposition(int min, int toBededutedFromMax) {
		return  ThreadLocalRandom.current().nextInt(0 + min, Main.getFrameX()-toBededutedFromMax);
	}
	/**
	 * Method to generate random Y position within the JPanel
	 * @return random integer within a range
	 */
	private int randomYposition() {
		return  ThreadLocalRandom.current().nextInt(0, Main.getFrameY());
	}
	/**
	 * Method by which the Space Objects are drawn 
	 * @param c = the Graphics
	 * @param color
	 * @param clusterOfSpaceObjects = the Array of X and Y object positions
	 * @param width
	 * @param height
	 * @param rectangle = if true, a Rectangle is drawn, else a circle
	 */
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
	/**
	 * Method which makes SpaceObjects fall, by increasing the Y values in their XYArrays
	 * @param positionArray = the Array which has the X and Y positions of the Objects
	 * @param gravity = how fast the objects fall
	 */
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

