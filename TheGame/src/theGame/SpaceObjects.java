package theGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
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
 * Creates 2D array with XY values for ordered Space objects 
 * @param x = array length
 * @param y = array[] length
 * @param xPosition = horizontal position in Panel
 * @param yPosition = vertical position 
 * @param gapX = X distance between SpaceObjects 
 * @param gapY = Y distance between SpaceObjects
 * @return Array with XY values. Each %==0 position in array contains X position, while %!=0 have Y positions
 */
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
	/**
	 * Creates 2D array with XY values for randomly flying Space objects
	 * @param x = array length
	 * @param y =array[] length
	 * @param size = size of the objects
	 * @return Array with XY values. Each %==0 position in array contains X position, while %!=0 have Y positions
	 */
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
	/**
	* 	Method to generate random X position within the Gameframe
	* @param size = the size of the object is taken into account so the object doesn't fall out of frame
	* @return random int within a range
	*/
	private int randomXposition(int size) {
		Random random = new Random();
		return random.nextInt(Main.getFrameX() - size - Gameplay.getShipStartingX() - + 1) + size +Gameplay.getShipStartingX();
	}
	/**
	 * Method to generate random Y position within the Gameframe
	 * @param size =the size of the object is taken into account so the object doesn't fall out of frame
	 * @return random int within a range
	 */
	private int randomYposition(int size) {
		Random random = new Random();
		return random.nextInt(Main.getFrameY() - size + 1) + size;
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

