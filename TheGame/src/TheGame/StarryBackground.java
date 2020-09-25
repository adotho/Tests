package TheGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class StarryBackground {
	int X=5;
	int Y =5;
	int dX=2;
	int dY=3;
	
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
		int [] xs = lineofStars(5);
		int []xss = lineofStars(55);
		for ( Y=1; Y<1500;) {
			for (int j=0; j<xs.length; j++) {
				if (Y%2== 0) b.fillRect(xss[j], Y , dX, dY);
				else b.fillRect(xs[j], Y , dX, dY);
			}
			Y+=51;
		}
		
		if (Y>1500) Y=0;
	}
}
