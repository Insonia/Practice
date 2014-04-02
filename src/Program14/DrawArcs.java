package Program14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawArcs extends JFrame {
	public DrawArcs(){
		setTitle("Milo SB");
		add(new ArcsPanle());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawArcs frame = new DrawArcs();
		frame.setSize(250,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class ArcsPanle extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xCenter = getWidth() /2;
		int yCenter = getHeight() /2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		int x = xCenter - radius;
		int y = yCenter - radius;
		
		g.setColor(Color.blue);
		g.fillArc(x, y, 2 *radius, 2*radius, 0, 30);
		g.fillArc(x, y, 2*radius, 2*radius, 90, 30);
		g.fillArc(x, y, 2*radius, 2*radius, 180, 30);
		g.fillArc(x, y, 2*radius, 2*radius, 270, 30);
	}
}
