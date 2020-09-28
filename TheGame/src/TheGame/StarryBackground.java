package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;

// Let's fill the sky with stars!
public class StarryBackground {
	private int dimensionX=2;
	private int dimensionY=3;
	private int Y;
	
	// method that generates an Array of 15 integers, each +100. Will be used for the X position of stars
	public int [] lineofStars(int value) {
		int []array = new int [15];
		for (int i=0; i<array.length; i++) {
				array[i] = value;
				value+=100;
		}
		return array;
	}
	
	public void drawstars (Graphics2D b) {
		b.setColor(Color.white);
		// the lineofStars generates 2 Arrays, one with 5, 105, 205 and the other with 55, 155, 255
		//in order to achieve in a triangular symmetry in the star pattern 
		int [] starline1 = lineofStars(5);
		int [] starline2 = lineofStars(55);
		
		// Y star position starts as 1 and increases to 1500, by 51 each time (the width of the frame)
		for ( Y=20; Y<800;) {
			for (int j=0; j<starline1.length; j++) {
				if (Y%2== 0) b.fillRect( starline2[j], Y , dimensionX, dimensionY);
				else b.fillRect(starline1[j], Y , dimensionX, dimensionY);
			}
			Y+=51;
		}
	}
}
