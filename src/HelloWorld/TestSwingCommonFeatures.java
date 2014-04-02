package HelloWorld;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TestSwingCommonFeatures extends JFrame {
	public TestSwingCommonFeatures()
	{
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,2,2));
		JButton jbtLeft = new JButton("Left");
		JButton jbtCenetr = new JButton("Center");
		JButton jbtRight = new JButton("Right");
		
		jbtLeft.setBackground(Color.white);
		jbtCenetr.setForeground(Color.GREEN);
		jbtRight.setToolTipText("This a tootip");
		
		p1.add(jbtLeft);
		p1.add(jbtCenetr);
		p1.add(jbtRight);
		p1.setBorder(new TitledBorder("Three Buttons"));
		
		Font largeFont = new Font("TimesRoman",Font.BOLD,20);
		Border lineBorder = new LineBorder(Color.black,2);
		
		JPanel p2 = new JPanel(new GridLayout(1,2,5,5));
		JLabel jlbRed = new JLabel("Red");
		JLabel jlbOrange = new JLabel("Orange");
		jlbRed.setForeground(Color.red);
		jlbOrange.setForeground(Color.orange);
		jlbRed.setFont(largeFont);
		jlbOrange.setFont(largeFont);
		jlbRed.setBorder(lineBorder);
		jlbOrange.setBorder(lineBorder);
		p2.add(jlbRed);
		p2.add(jlbOrange);
		p2.setBorder(new TitledBorder("Two Labels"));
		
		
		setLayout(new GridLayout(2,1,5,5));
		add(p1);
		add(p2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestSwingCommonFeatures();
		frame.setTitle("Milo SB");
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
