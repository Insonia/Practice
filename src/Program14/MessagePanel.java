package Program14;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private String messageString = "Welcome to Java";
	private int xCoordinate =20;
	private int yCoordinate = 20;
	private boolean centered;
	private int interval = 10;
	
	public MessagePanel(){
		
	}
	
	public  MessagePanel(String message) {
		this.messageString = message;
		
	}
	
	public MessagePanel (String message, boolean centered) {
		this.messageString = message;
		this.centered = centered;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(centered){
			FontMetrics fm = g.getFontMetrics();
			
			int stringWidth = fm.stringWidth(messageString);
			int stringAscent = fm.getAscent();
			
			xCoordinate = getWidth() /2 - stringWidth /2;
			yCoordinate = getHeight() / 2 + stringAscent /2;
		}
		
		g.drawString(messageString, xCoordinate, yCoordinate);
	}
	
	public void moveLeft() {
		xCoordinate += interval;
		repaint();
	}
	
	public void moveRight() {
		xCoordinate -= interval;
		repaint();
	}
	
	public void moveUp() {
		yCoordinate -= interval;
		repaint();
	}
	
	public void moveDown() {
		yCoordinate += interval;
		repaint();
	}
	
}
