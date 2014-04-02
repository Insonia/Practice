package isA;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class ToolBarDemo extends JFrame{
	//private JToolBar jtb = new JToolBar();
	private JButton jbtNew = new JButton(new ImageIcon("imag/1.png"));
	private JButton jbtOpen = new JButton(new ImageIcon("imag/1.png"));
	private JButton jbtCut = new JButton(new ImageIcon("imag/1.png"));
	
	public ToolBarDemo(){
		JToolBar jtb = new JToolBar("My ToolBar");
		jtb.setFloatable(true);
		jtb.add(jbtNew);
		jtb.add(jbtOpen);
		jtb.add(jbtCut);
		
		jbtNew.setBorderPainted(false);
		jbtOpen.setBorderPainted(false);
		jbtCut.setBorderPainted(false);
		
		add(jtb,BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ToolBarDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
