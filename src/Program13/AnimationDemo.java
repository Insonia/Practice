package Program13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationDemo extends JFrame {
	public AnimationDemo(){
		add(new MovingMessagePanle("message moving?"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new AnimationDemo();
		frame.setTitle("Milo SB");
		frame.setSize(280,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static class MovingMessagePanle extends JPanel{
		private String messageString = "Welcome to Java";
		private int xCoordinate = 0;
		private int yCoordinate = 20;
		
		public MovingMessagePanle(String messageString){
			this.messageString = messageString;
			
			Timer timer = new Timer(1000, new TimerListener());
			timer.start();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(xCoordinate > getWidth())
				xCoordinate = -20;
			xCoordinate +=5;
			g.drawString(messageString, xCoordinate, yCoordinate);
		}
	
	class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
		}
		
	}
	}
}
