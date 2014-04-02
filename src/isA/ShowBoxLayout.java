package isA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ShowBoxLayout extends JFrame {
	private Box box1 = Box.createHorizontalBox();
	private Box box2 = Box.createVerticalBox();
	
	private JLabel jlbFlag = new JLabel();
	
	private ImageIcon imageIcon1 = new ImageIcon("imag/flag1.png");
	private ImageIcon imageIcon2 = new ImageIcon("imag/flag2.png");
	private ImageIcon imageIcon3 = new ImageIcon("imag/flag3.png");
	private ImageIcon imageIconPrint = new ImageIcon("imag/1.png");
	private ImageIcon imageIconSave = new ImageIcon("imag/1.png");
	
	private JButton jbt1 = new JButton("1");
	private JButton jbt2 = new JButton("2");
	private JButton jbt3 = new JButton("3");
	
	public ShowBoxLayout(){
		box1.add(new JButton(imageIconPrint));
		box1.add(Box.createHorizontalStrut(20));
		box1.add(new JButton(imageIconSave));
		
		box2.add(jbt1);
		box2.add(box1.createVerticalStrut(9));
		box2.add(jbt2);
		box2.add(Box.createGlue());
		box2.add(jbt3);
		
		box1.setBorder(new LineBorder(Color.red));
		box2.setBorder(new LineBorder(Color.black));
		
		add(box1,BorderLayout.NORTH);
		add(box2,BorderLayout.EAST);
		add(jlbFlag,BorderLayout.CENTER);
		
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			jlbFlag.setIcon(imageIcon1);	
			}
		});
		
		jbt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlbFlag.setIcon(imageIcon2);
			}
		});
		
		jbt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlbFlag.setIcon(imageIcon3);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ShowBoxLayout();
		frame.setTitle("Milo SB");
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
