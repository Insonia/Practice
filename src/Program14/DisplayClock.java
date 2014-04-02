package Program14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class DisplayClock extends JFrame {
	public DisplayClock(){
		StillClock clock = new StillClock();
		clock.setCurrentTme();
		
		MessagePanel messagePanel = new MessagePanel(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
		messagePanel.setCentered(true);
		messagePanel.setForeground(Color.blue);
		messagePanel.setFont(new Font("Courier", Font.BOLD, 16));
		
		setLayout(new BorderLayout());
		add(clock);
		add(messagePanel,BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new DisplayClock();
		frame.setTitle("Milo SB");
		frame.setSize(300,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
