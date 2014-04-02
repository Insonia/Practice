package Program13;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SierpinskiTriangle extends JFrame {
	private JTextField jtfOrder = new JTextField("0",5);
	private SierpinskiTrianglePanel triangelPanel = new SierpinskiTrianglePanel();
	
	public SierpinskiTriangle(){
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter an order: "));
		panel.add(jtfOrder);
		jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		
		add(triangelPanel);
		add(panel,BorderLayout.SOUTH);
		
		jtfOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				triangelPanel.setOrder(Integer.parseInt(jtfOrder.getText()));
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SierpinskiTriangle();
		frame.setTitle("Milo Sb");
		frame.setSize(1000,900);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static class SierpinskiTrianglePanel extends JPanel{
		private int order = 0;
		
		public void setOrder(int order){
			this.order = order;
			repaint();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Point p1 = new Point(getWidth() / 2, 10);
			Point p2 = new Point(10,getHeight() - 10);
			Point p3 = new Point(getWidth() - 10, getHeight() - 10);
			
			displayTriangles(g, order, p1, p2, p3);
		}
	}
	
	private static void displayTriangles(Graphics g, int order, Point p1, Point p2,Point p3) {
		if(order >= 0){
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y);
			g.drawLine(p3.x, p3.y, p1.x, p1.y);
			
			Point p12 = midPoint(p1, p2);
			Point p23 = midPoint(p2, p3);
			Point p13 = midPoint(p1, p3);
			
			displayTriangles(g, order-1, p1, p12, p13);
			displayTriangles(g, order-1, p12, p2, p23);
			displayTriangles(g, order-1, p13, p23, p3);
		}
	}
	
	public static Point midPoint(Point p1,Point p2) {
		return new Point((p1.x + p2.x)/2,(p1.y + p2.y)/2);
	}
	
//	class Point{
//		int x;
//		int y;
//		
//		public Point(){
//			
//		}
//		
//		public Point(int x,int y){
//			this.x = x;
//			this.y = y;
//		}
//	}

}
