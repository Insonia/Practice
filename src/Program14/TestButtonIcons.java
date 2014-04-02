package Program14;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonIcons extends JFrame {
	public TestButtonIcons(){
		ImageIcon usIcon = new ImageIcon("usa.png");
		ImageIcon chIcon = new ImageIcon("china.png");
		ImageIcon enIcon = new ImageIcon("english.png");
		
		JButton jbt = new JButton("Click it", usIcon);
		jbt.setPressedIcon(chIcon);
		jbt.setRolloverIcon(enIcon);
		
		add(jbt);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestButtonIcons();
		frame.setTitle("Milo SB");
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
