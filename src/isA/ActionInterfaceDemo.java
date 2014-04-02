package isA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ActionInterfaceDemo extends JFrame {
	private JPanel buttonPanel = new JPanel();
	private FlowLayout flowLayout = new FlowLayout();
	
	public ActionInterfaceDemo(){
		ImageIcon icon = new ImageIcon("imag/1.png");
		
		Action leftAction = new MyAction("Left", icon,"Left Alignment", new Integer(KeyEvent.VK_L),KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		Action centerAction = new MyAction("Center", icon,"Center Alignment", new Integer(KeyEvent.VK_C),KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		Action rightAction = new MyAction("Right", icon,"Right Alignment", new Integer(KeyEvent.VK_R),KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
	
		JMenuBar jMenuBar1 = new JMenuBar();
		JMenu jmenuAlignment = new JMenu("Alignment");
		jMenuBar1.add(jmenuAlignment);
		
		jmenuAlignment.add(leftAction);
		jmenuAlignment.add(centerAction);
		jmenuAlignment.add(rightAction);
		
		JToolBar jtb1 = new JToolBar(JToolBar.VERTICAL);
		jtb1.setBorder(BorderFactory.createLineBorder(Color.red));
		jtb1.add(leftAction);
		jtb1.add(centerAction);
		jtb1.add(rightAction);
		
		buttonPanel.setLayout(flowLayout);
		JButton jbtLeft = new JButton(leftAction);
		JButton jbtCenter = new JButton(centerAction);
		JButton jbtRight = new JButton(rightAction);
		buttonPanel.add(jbtLeft);
		buttonPanel.add(jbtCenter);
		buttonPanel.add(jbtRight);
		
		add(jtb1,BorderLayout.EAST);
		add(buttonPanel,BorderLayout.CENTER);
		add(jMenuBar1,BorderLayout.NORTH);
	}
	
	private class MyAction extends AbstractAction{
		String name;
		
		public MyAction(String name, Icon icon){
			super(name,icon);
			this.name = name;
			}
		
		public MyAction(String name, Icon icon, String desc, Integer mnemonic, KeyStroke accelerator) {
			// TODO Auto-generated constructor stub
			super(name,icon);
			putValue(Action.SHORT_DESCRIPTION, desc);
			putValue(Action.MNEMONIC_KEY, mnemonic);
			putValue(Action.ACCELERATOR_KEY, accelerator);
			this.name = name;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(name.equals("Left"))
				flowLayout.setAlignment(FlowLayout.LEFT);
			else if(name.equals("Center"))
				flowLayout.setAlignment(FlowLayout.CENTER);
			else if(name.equals("Right"))
				flowLayout.setAlignment(FlowLayout.RIGHT);
			
			buttonPanel.revalidate();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ActionInterfaceDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
