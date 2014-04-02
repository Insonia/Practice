package Program14;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCenterMessage extends JFrame {

	public TestCenterMessage(){
		CenterMessage messagePanel = new CenterMessage();
		add(messagePanel);
		messagePanel.setBackground(Color.white);
		messagePanel.setFont(new Font("Californian FB", Font.BOLD, 30));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestCenterMessage();
		frame.setTitle("Milo SB");
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class CenterMessage extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		FontMetrics fm = g.getFontMetrics();
		
		int stringWidh = fm.stringWidth("Welcome to Java");
		int stringHeight = fm.getAscent();
		
		int xCoordinate = getWidth() / 2 - stringWidh / 2;
		int yCoordinate = getHeight() / 2 + stringHeight / 2;
		
		g.drawString("Welcome to Java", xCoordinate, yCoordinate);
	}
}