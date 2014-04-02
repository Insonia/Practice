package Program13;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveMessageDemo extends JFrame {
	public MoveMessageDemo(){
		MovableMessagePanel p = new MovableMessagePanel("Welcome to Java");
		
		setLayout(new BorderLayout());
		add(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MoveMessageDemo();
		frame.setTitle("Milo SB");
		frame.setSize(200,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static class MovableMessagePanel extends JPanel{
		private String message = "Welcome to Java";
		private int x = 20;
		private int y = 20;
		
		public MovableMessagePanel(String s){
			message = s;
			
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseMoved(MouseEvent e){
					x= e.getX();
					y= e.getY();
					repaint();
				}
			});
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
 	}

}
