package Program14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FigurePanel extends JPanel {
	public static final int LINE =1;
	public static final int RECTANGLE = 2;
	public static final int ROUND_RECTANGLE =3;
	public static final int OVAL =4;
	
	private int type =1;
	private boolean filled = false;
	
	public FigurePanel(){
		
	}
	
	public FigurePanel(int type){
		this.setType(type);
	}
	
	public FigurePanel(int type, boolean filled){
		this.setType(type);
		this.setFilled(filled);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		switch (getType()) {
		case LINE:
			g.setColor(Color.black);
			g.drawLine(10, 10, width-10, height-10);
			g.drawLine(width-10, 10, 10, height-10);
			break;
		case RECTANGLE:
			g.setColor(Color.blue);
			if(isFilled())
				g.fillRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height));
			else
				g.drawRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height));
			break;
		case ROUND_RECTANGLE:
			g.setColor(Color.red);
			if(isFilled())
				g.fillRoundRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height), 20, 20);
			else 
				g.drawRoundRect((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height),20,20);
			break;
		case OVAL:
			if(isFilled())
				g.fillOval((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height));
			else 
				g.drawOval((int)(0.1 * width), (int)(0.1 * height), (int)(0.8 * width), (int)(0.8*height));
			break;
		default:
			break;
		}
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
//	public Dimension getPreferredSize() {
//		return new Dimension(80.80);
//	}
	
}
