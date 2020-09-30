package TheGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	private static int level= 1; // game level
	public static int getLevel() {
		return level;
	}
	private final ArrayList<Integer> pressedKeys;   // List of pressed Keys for as long as they are pressed. Used in keyPressed()
	private boolean play= false;
	private final int shipStartingX=40; // X position of the spaceship
	private final int shipStartingY=700; // Y position of the spaceship
	private int shipX=shipStartingX;
	private int shipY=shipStartingY; 
	private final static int shipWidth=30 ;
	public static int getShipwidth() {
		return shipWidth;
	}
	public int getShipStartingX() {
		return shipStartingX;
	}
	private final static int shipHeight=50 ;
	private Timer timer;
	private int delay = 8;
	Meteors meteors = new Meteors();
	StarryBackground starbackground = new StarryBackground();
	 
	public Gameplay() {
		pressedKeys = new ArrayList<>();
		addKeyListener (this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer (delay, this);
		timer.start();
	}
	
	// the game is drawn
	public void paint(Graphics g) {
				
		//black background
		g.setColor(Color.black);
		g.fillRect(0,0, Main.getFrameX(),Main.getFrameY());
		
		//make it starry
		starbackground.drawstars((Graphics2D) g);
		
		if (play==false) {
			g.setColor(Color.RED);
			g.setFont(new Font ("serif", Font.PLAIN, 40));
			g.drawString("Press Enter to fly to the moon", 525, 480);
		}
		
		//display Level
		g.setColor(Color.WHITE);
		g.setFont(new Font ("serif", Font.BOLD, 40));
		g.drawString("Level: " + level, 30, 40);
		
		//the moon
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(1200, 70, 150, 150);
		
		 //meteors   
		meteors.drawMeteors((Graphics2D) g);
		
		//spaceship
		g.setColor(Color.gray);
		g.fillRect(shipX, shipY, shipWidth, shipHeight);
		
		if (detectMeteorCollision()) {
			// if their position is the same, game over
			g.setColor(Color.RED);
			g.setFont(new Font ("serif", Font.BOLD, 60));
			g.drawString("Game Over!", 550, 400);
			g.setFont(new Font ("serif", Font.PLAIN, 40));
			g.drawString("Press Enter to restart", 525, 480);
			shipX=shipStartingX;
			shipY=shipStartingY;
			level=1;
			timer.stop();			
			play=false;	
		}
				
		//if statement to check if spaceship reaches the moon
		if (detectMoonLanding()) {
			//6 levels to reach the moon
			if (level>6) {
				g.setColor(Color.black);
				g.fillRect(0,0, Main.getFrameX(), Main.getFrameY());
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font ("serif", Font.BOLD, 60));
				g.drawString("You reached the moon!", 450, 400);
				timer.stop();
				play=false;
			} 
			// if level<=6, then the spaceship returns to starting position and level increases.
			shipX=shipStartingX;
			shipY=shipStartingY;
			level++;
			meteors = new Meteors();
		}
		g.dispose();
	}
	
	private boolean detectMeteorCollision() {
	//for loop in which each meteors position is compared with the spaceship's
		for (int i =0; i<meteors.getAllMeteors().length; i++) {
			for (int k=0; k<meteors.getAllMeteors()[i].length; k+=2 ) {
				if (new Rectangle(shipX, shipY, 25, 45).intersects(new Rectangle(meteors.getAllMeteors()[i][k], meteors.getAllMeteors()[i][k+1],30,30))) {
					return true;
				}
			}
		}
	return false;
	}
	
	private boolean detectMoonLanding() {
		return
		new Rectangle(shipX, shipY, 30, 50).intersects(new Rectangle(1220, 70, 100, 100));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
		//gravity always pulls spaceship downwards. If it reaches bottom, it just stays there
			if (shipY>=740) {
			shipY=740;
			}
			else shipY++;
		
		//make meteors fall (if statement checks if they have fallen. If yes, they return to the top)
				for (int i =0; i<meteors.getAllMeteors().length; i++) {
				int [][] temporaryMeteorPositions = meteors.getAllMeteors();
					for (int k=0; k<meteors.getAllMeteors()[i].length; k++ ) {
							if (k%2!=0) {
								if (meteors.getAllMeteors()[i][k]>780) {
									temporaryMeteorPositions[i][k]=0;
									meteors.setAllMeteors(temporaryMeteorPositions);
								}
								temporaryMeteorPositions[i][k]+=5;
								meteors.setAllMeteors(temporaryMeteorPositions);
							}
					}
				}	
	}
	repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	// avoid spaceship going out of frame bounds && movement configuration
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER && play==false) {
			timer.restart();
			play=true;
			meteors= new Meteors();
		}
		if(play)  {
	        if(!pressedKeys.contains((e.getKeyCode()))){
	            pressedKeys.add(e.getKeyCode());
	        }
	        if(pressedKeys.contains(KeyEvent.VK_RIGHT) ){
				if (shipX >= Main.getFrameX()-50) {
					shipX = Main.getFrameX()-50;
				}
				else moveRight();
	        }
	        if(pressedKeys.contains(KeyEvent.VK_LEFT)){
	    		if (shipX <= 0) {
	    			shipX = 0;
	    			}
	    		else moveLeft();
	  
	        }
	        if(pressedKeys.contains(KeyEvent.VK_UP)){
	    		if (shipY <= 0) {
	    			shipY = 0;
	    		}
	    		else moveUp();
	        }
	        if(pressedKeys.contains(KeyEvent.VK_DOWN)){
				if (shipY >= Main.getFrameY()) {
					shipY = Main.getFrameY();
				}
				else moveDown();
	        }	       	       
	    }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
	}
	
	//movement methods
	public void moveRight() {
		if	(play==true) shipX+=20;
	}
	public void moveLeft() {
		if	(play==true) shipX-=20;
	}
	public void moveUp() {
		if	(play==true) shipY-=20;
	}
	public void moveDown() {
		if	(play==true) shipY+=20;
	}

}
