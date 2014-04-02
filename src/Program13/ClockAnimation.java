package Program13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import HelloWorld.AdditionQuize;
import Program13.AnimationDemo.MovingMessagePanle.TimerListener;
import Program14.DisplayClock;
import Program14.StillClock;

public class ClockAnimation extends JFrame {
	private StillClock clock = new StillClock();
	
	public ClockAnimation(){
		add(clock);
		
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ClockAnimation();
		frame.setTitle("Milo SB");
		frame.setSize(300,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			clock.setCurrentTme();
			clock.repaint();
		}
		
	}

}
