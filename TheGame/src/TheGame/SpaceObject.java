package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceObject {
private int xPosition;
protected int yPosition;
/* protected int sizeX=0;
protected int sizeY=0;
protected int gapX=0;
protected int gapY=0;

public SpaceObject (int a, int b, int c,int d, int e, int f) {
a= xPosition;
b= yPosition;
c= sizeX;
d= sizeY;
e= gapX;
f= gapY;
} */

	protected int [][] createCluster(int x, int y, int gapX, int gapY){
	int clusterOfSpaceObjects[][]= new int [x][y];
		for (int i=0; i< x; i++) {
			for (int j=0; j<y; j++) {
				if (j%2==0)clusterOfSpaceObjects [i][j]=xPosition;
				else clusterOfSpaceObjects[i][j]=yPosition;
				xPosition+= gapX;
			}
			if (i%2==0) xPosition=10;
			else xPosition=50;	
		yPosition+=gapY;
		}
		return clusterOfSpaceObjects;
	}
	public void drawClusterofObjects (Graphics2D c, Color color, int [][] clusterOfSpaceObjects, int width, int height) {
		c.setColor(color);
		for (int j=0; j<clusterOfSpaceObjects.length; j++) {
			for (int i=0; i<clusterOfSpaceObjects[j].length-1; i+=2) {
				c.fillRect(clusterOfSpaceObjects[j][i], clusterOfSpaceObjects[j][i+1],width, height);
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

