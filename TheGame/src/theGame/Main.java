package theGame;

import javax.swing.JFrame;

/**
 * GameFrame which loads the gameplay panel
 */

public class Main {
	
	private static final int FRAME_X=1500;
	private static final int FRAME_Y=800;
	private static final int FRAME_BOUNDS=20;
	private static final String GAME_NAME= "I 'm gonna send me to Outer Space and find another race";
		
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(FRAME_BOUNDS,FRAME_BOUNDS,FRAME_X,FRAME_Y);
		frame.setTitle(GAME_NAME);
		
	
		Gameplay gameplay = new Gameplay();
		frame.add(gameplay);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static int getFrameBounds() {
		return FRAME_BOUNDS;
	}

	public static int getFrameX() {
		return FRAME_X;
	}

	public static int getFrameY() {
		return FRAME_Y;
	} 	
}
