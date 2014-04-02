package milo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import Program14.StillClock;

public class ClockWithAudio extends JFrame {
	private StillClock clock = new StillClock();
	
	private JLabel jlbDigitTime= new JLabel("", JLabel.CENTER);
	
	public ClockWithAudio(){
		add(clock,BorderLayout.CENTER);
		add(jlbDigitTime,BorderLayout.SOUTH);
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}

	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			clock.setCurrentTme();
			clock.repaint();
			jlbDigitTime.setText(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
			if(clock.getSecond() == 0)
				announceTime(clock.getHour(), clock.getMinute());
		}
		
	}
	
	public void announceTime(int hour, int minutes){
		System.out.println("Now " + hour);
		try {
			Thread.sleep(1500);
			System.out.println(":" + minutes);
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ClockWithAudio();
		frame.setTitle("Milo SB");
		frame.setSize(250,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
