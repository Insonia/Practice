package HelloWorld;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ShowBorderLayout extends JFrame {
	public ShowBorderLayout()
	{
		setLayout(new BorderLayout(10,10));
		
		add(new JButton("North"),BorderLayout.NORTH);
		add(new JButton("East"),BorderLayout.EAST);
		add(new JButton("South"),BorderLayout.SOUTH);
		add(new JButton("West"),BorderLayout.WEST);
		add(new JButton("Center"),BorderLayout.CENTER);
		//add(new JButton("SEE?"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowBorderLayout frame = new ShowBorderLayout();
		
		frame.setTitle("ShowBorderLayout");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
