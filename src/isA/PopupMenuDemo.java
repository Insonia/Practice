package isA;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PopupMenuDemo extends JFrame {
	private JPopupMenu jPopupMenu1 = new JPopupMenu();
	private JMenuItem jmiNew = new JMenuItem("New",new ImageIcon("imag/1.png"));
	private JMenuItem jmiOpen = new JMenuItem("Open", new ImageIcon("imag/1.png"));
	private JMenuItem jmiPrint  = new JMenuItem("Print", new ImageIcon("imag/1.png"));
	private JMenuItem jmiExit = new JMenuItem("Exit");
	private JTextArea jta = new JTextArea();
	
	public PopupMenuDemo(){
		jPopupMenu1.add(jmiNew);
		jPopupMenu1.add(jmiOpen);
		jPopupMenu1.add(jmiPrint);
		jPopupMenu1.add(jmiExit);
		
		add(new JScrollPane(jta),BorderLayout.CENTER);
		
		jmiNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Process New");
			}
		});
		
		jmiOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Process Open");
			}
		});
		
		jmiPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Process Print");
			}
		});
		
		jmiExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		jta.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showPop(e);	
			}
			
			public void mouseReleased(MouseEvent e) {
				showPop(e);
			}
		});
	}
	
	private void showPop(MouseEvent e) {
		if(e.isPopupTrigger())
			jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PopupMenuDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
