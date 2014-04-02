package sb;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CircleView extends JPanel implements ActionListener{
	private CircleModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	public CircleModel getModel() {
		return model;
	}

	public void setModel(CircleModel model) {
		this.model = model;
		
		if(this.model != null)
			this.model.addActionListener(this);
		
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(this.model == null) return;
		
		g.setColor(this.model.getColor());
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)this.model.getRadius();
		
		if(this.model.isFiiled()){
			g.fillOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
		}
		else {
			g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
		}
	}
}
