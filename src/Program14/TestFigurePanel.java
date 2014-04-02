package Program14;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestFigurePanel extends JFrame {

	public TestFigurePanel(){
		setLayout(new GridLayout(2,3,5,5));
		
		add(new FigurePanel(FigurePanel.LINE));
		add(new FigurePanel(FigurePanel.RECTANGLE));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
		add(new FigurePanel(FigurePanel.OVAL));
		add(new FigurePanel(FigurePanel.RECTANGLE,true));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE,true));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestFigurePanel();
		frame.setTitle("Milo SB");
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
