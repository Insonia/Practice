package HelloWorld;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUIComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JButton jbtOK = new JButton("OK");
		
		JButton jbtCancel = new JButton("Cancel");
		
		JLabel jlblName = new JLabel("Enter your name");
		
		JTextField jtfName = new JTextField("Type name here");
		
		JCheckBox jchkBold = new JCheckBox("Bold");
		
		JCheckBox jchkItalic = new JCheckBox("Italic");
			
		JRadioButton jrbRed = new JRadioButton("Red");
		
		JRadioButton jrdYellow = new JRadioButton("Yellow");
		
		JComboBox jcboColor = new JComboBox(new String[]{"Freshman","Sophomore","Junior","Senior"});
		
		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		panel.add(jlblName);
		panel.add(jtfName);
		panel.add(jchkBold);
		panel.add(jchkItalic);
		panel.add(jrbRed);
		panel.add(jrdYellow);
		panel.add(jcboColor);
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("Show GUI Compoents");
		frame.setSize(450, 100);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
 	}

}
