package TheGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7829820332938518749L;
	static int level= 1;
	private boolean play= false;
	private int shipX=50;
	private int shipY=700;
	private Timer timer;
	private int delay = 8;
	Meteors meteors = new Meteors();
	StarryBackground starbackground = new StarryBackground();
	
	public Gameplay() {
		addKeyListener (this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer (delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		//black background
		g.setColor(Color.black);
		g.fillRect(1,1, Main.fX,Main.fY);
		
		//make it starry
		starbackground.drawstars((Graphics2D) g);

		//Level
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
		g.fillRoundRect(shipX, shipY, 30, 50, 10, 10);
		
		//for loop in which each meteors position is compared with the spaceship's
		for (int i =0; i<meteors.metXY.length; i++) {
			for (int k=0; k<meteors.metXY[i].length; k+=2 ) {
				if (new Rectangle(shipX, shipY, 30, 50).intersects(new Rectangle(meteors.metXY[i][k], meteors.metXY[i][k+1],30,30))) {
					
					// if their position is the same, game over
					g.setColor(Color.RED);
					g.setFont(new Font ("serif", Font.BOLD, 60));
					g.drawString("Game Over!", 550, 400);
					g.setFont(new Font ("serif", Font.PLAIN, 40));
					g.drawString("Press Enter to restart", 525, 480);
					shipX=50;
					shipY=700;
					level=1;
					meteors = new Meteors();
					play=false;
					timer.stop();
					
				}
			}
		}
		//if statement to check if spaceship reaches the moon
		if (new Rectangle(shipX, shipY, 30, 50).intersects(new Rectangle(1200, 70, 100, 100))) {
			//if you win level 6, then you win the game!
			if (level>2) {
				play=false;
				g.setColor(Color.black);
				g.fillRect(1,1, Main.fX, Main.fY);
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font ("serif", Font.BOLD, 60));
				g.drawString("You reached the moon!", 450, 400);
				timer.stop();
			} 
			// if level<=6, then the spaceship returns to starting position and level increases.
			shipX=50;
			shipY=700;
			level++;
			meteors = new Meteors();
		}
		g.dispose();
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
			for (int i =0; i<meteors.metXY.length; i++) {
				for (int k=0; k<meteors.metXY[i].length; k++ )
					if (k%2!=0) {
						if (meteors.metXY[i][k]>780) {
						meteors.metXY[i][k]=0;
						}
						meteors.metXY[i][k]+=5;
					}
				}
			}		
	repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	// avoid spaceship going out of bounds && movement configuration
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		//	if (play==false) {
			level=1;
			timer.restart();
			shipX=50;
			shipY=700;
			play=true;
		//}
	}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if (shipX >= 1450) {
				shipX = 1450;
			}
			else moveRight();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if (shipX <= 10) {
				shipX = 10;
			}
			else moveLeft();
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			if (shipY <= 0) {
				shipY = 0;
			 }
			else moveUp();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			if (shipY >= Main.fX) {
				shipY = Main.fX;
			}
			else moveDown();
		}
	}
	
	//movement methods
	public void moveRight() {
		if	(play=true) shipX+=20;
	}
	public void moveLeft() {
		if	(play=true) shipX-=20;
	}
	public void moveUp() {
		if	(play=true) shipY-=20;
	}
	public void moveDown() {
		if	(play=true) shipY+=20;
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}

}
