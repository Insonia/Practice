package HelloWorld;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowGridLayout extends JFrame {
	
	public ShowGridLayout()
	{
		setLayout(new GridLayout(0,1));
		
		add(new JLabel("    First Nmae"));
		add(new JTextField());
		add(new JLabel("    MI"));
		add(new JTextField());
		add(new JLabel("    Last Name"));
		add(new JTextField());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowGridLayout frame = new ShowGridLayout();
		
		frame.setTitle("ShowGridFram");
		frame.setSize(200,125);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
