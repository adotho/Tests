package TheGame;

import javax.swing.JFrame;

public class Main {
	// X and Y dimensions of the JFrame	
	static final int frameX=1500;
	static final int frameY=800;
	static final int frameBounds=10;
	static final String gameName= "I 'm gonna send me to Outer Space and find another race";
		
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(frameBounds,frameBounds,frameX,frameY);
		frame.setTitle(gameName);
		
		// Gameplay panel is instantiated and added to JFrame
		Gameplay gameplay = new Gameplay();
		frame.add(gameplay);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 	
}
