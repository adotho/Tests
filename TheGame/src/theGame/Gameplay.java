package theGame;
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
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author Antonia
 * the game panel
 * Moon, spaceship and strings do not exist as objects and are drawn directly on the panel.
 *	
 */

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	private static int level= 1; 
	public static int getLevel() {
		return level;
	}
	//Array of pressed keys allows diagonal movement
	private final ArrayList<Integer> pressedKeys;
	private boolean play= false;
	private static final int shipStartingX=40; 
	private static final int shipStartingY=700; 
	private int shipX=shipStartingX;
	private int shipY=shipStartingY; 
	private final static int shipWidth=30 ;
	private final int moonPositionX= 1300 ;
	private final int moonPositionY = 50 ;
	private final int moonSize= 150;
			
	public static int getShipwidth() {
		return shipWidth;
	}
	public static int getShipStartingX() {
		return shipStartingX;
	}
	private final static int shipHeight=50 ;
	public static int getShipheight() {
		return shipHeight;
	}
	private Timer timer;
	private int delay = 8; // number for delay used in game tutorial. Run smoothly
	Meteors meteors = new Meteors();
	FallingStars fallingStars =  new FallingStars();
	
	public Gameplay() {
		pressedKeys = new ArrayList<>();
		addKeyListener (this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer (delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(0,0, Main.getFrameX(),Main.getFrameY());
		
		//falling stars in background
		fallingStars.drawClusterofObjects ((Graphics2D) g, Color.white, fallingStars.getFallingStarsArray(), fallingStars.getSizeX(), fallingStars.getSizeY(), false);
		
		//Starting menu
		if (play==false) {
			g.setColor(Color.white);
			g.setFont(new Font ("serif", Font.PLAIN, 40));
			g.drawString("Press Enter to fly to the moon", 520, 450);
		}
		
		//display Level
		g.setColor(Color.WHITE);
		g.setFont(new Font ("serif", Font.BOLD, 40));
		g.drawString("Level: " + level, 30, 40);
		
		//the moon
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(moonPositionX, moonPositionY, moonSize, moonSize);
		
		//meteors   
		meteors.drawClusterofObjects((Graphics2D) g, Color.red, meteors.getAllMeteors(), meteors.getSize(), meteors.getSize(), false );
		
		//spaceship
		g.setColor(Color.gray);
		g.fillRect(shipX, shipY, shipWidth, shipHeight);
		
		if (detectMeteorCollision()) {
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
				
		if (detectMoonLanding()) {
			if (level>5) {
				g.setColor(Color.black);
				g.fillRect(0,0, Main.getFrameX(), Main.getFrameY());
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font ("serif", Font.BOLD, 60));
				g.drawString("You reached the moon!", 450, 400);
				timer.stop();
				play=false;
			} 
			shipX=shipStartingX;
			shipY=shipStartingY;
			level++;
			meteors = new Meteors();
		}
		g.dispose();
	}
	/**Compares position of spaceship with that of the meteors, using their array of X and Y positions
	 * @return boolean
	 * 
	 */
	private boolean detectMeteorCollision() {
		for (int i =0; i<meteors.getAllMeteors().length; i++) {
			for (int k=0; k<meteors.getAllMeteors()[i].length; k+=2 ) {
				if (new Rectangle(shipX, shipY, shipWidth, shipHeight).intersects(new Rectangle(meteors.getAllMeteors()[i][k], meteors.getAllMeteors()[i][k+1],meteors.getSize()-5,meteors.getSize()-5)))
				//	intersects method takes Rectangles as parameters. Meteors are circles, so I used trial and error with numbers to get a good result 
				{
					return true;
				}
			}
		}
	return false;
	}
	/**
	 * Compares position of spaceship with that of the moon
	 * @return boolean
	 */
	private boolean detectMoonLanding() {
		return
		new Rectangle(shipX, shipY, shipWidth, shipHeight).intersects(new Rectangle(moonPositionX-moonSize/3, moonPositionY-moonSize/2, moonSize+30, moonSize));
		//Numbers generated through trial and error, as intersects compares a rectangle with a rectangle
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
		//gravity always pulls spaceship downwards. If it reaches bottom, it just stays there
			if (shipY>=Main.getFrameY()-Main.getFrameBounds()-shipHeight) {
			shipY=Main.getFrameY()-Main.getFrameBounds()-shipHeight;
			}
			else shipY++;
		
		meteors.spaceObjectFalls(meteors.getAllMeteors(), 5);
		fallingStars.spaceObjectFalls(fallingStars.getFallingStarsArray(), 1);
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
	private void moveRight() {
		if	(play==true) shipX+=15;
	}
	private void moveLeft() {
		if	(play==true) shipX-=15;
	}
	private void moveUp() {
		if	(play==true) shipY-=15;
	}
	private void moveDown() {
		if	(play==true) shipY+=15;
	}

}
