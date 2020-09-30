package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class FallingStars extends SpaceObject{
	int xPosition= 5;
	int yPosition= 5;
	int sizeX= 2;
	int sizeY= 8;
	int gapX= 50;
	int gapY= 50;

	int fallingStarsPositions[][]= createCluster( Main.getFrameY()/this.gapY, Main.getFrameX()/this.gapX, this.gapY, this.gapX);
	

}

