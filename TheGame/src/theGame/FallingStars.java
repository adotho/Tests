package theGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class FallingStars extends SpaceObjects{
	private int xPosition= 5;
	private int yPosition= 5;
	private int sizeX= 2;
	private int sizeY= 8;
	private int gapX= 50;
	private int gapY= 50;
	private int fallingStarsArray[][]= createCluster( Main.getFrameY()/gapY, Main.getFrameX()/gapX, xPosition, yPosition, gapX, gapY);
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	public int getGapX() {
		return gapX;
	}
	public void setGapX(int gapX) {
		this.gapX = gapX;
	}
	public int getGapY() {
		return gapY;
	}
	public void setGapY(int gapY) {
		this.gapY = gapY;
	}
	public int[][] getFallingStarsArray() {
		return fallingStarsArray;
	}
	public void setFallingStarsArray(int[][] fallingStarsArray) {
		this.fallingStarsArray = fallingStarsArray;
	}
}

