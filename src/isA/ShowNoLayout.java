package isA;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ShowNoLayout extends JFrame {
	private JButton jbtRed = new JButton("Red");
	private JButton jbtBlue = new JButton("Blue");
	private JButton jbtBlack = new JButton("Black");
	
	public ShowNoLayout(){
		setLayout(null);
		add(jbtBlack);
		add(jbtRed);
		add(jbtBlue);
		
		jbtBlack.setBounds(150, 50, 100, 50);
		jbtRed.setBounds(100, 100, 100, 50);
		jbtBlue.setBounds(200, 100, 100, 50);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ShowNoLayout();
		frame.setTitle("Milo SB");
		frame.setSize(400,400);
		frame.setVisible(true);
	}

}
