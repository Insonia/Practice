package Program14;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxDemo extends JFrame {
	private JCheckBox jchkCentered = new JCheckBox("Centered");
	private JCheckBox jchkBold = new JCheckBox("Bold");
	private JCheckBox jchkItalic = new JCheckBox("Italic");
	
	protected MessagePanel messagePanel = new MessagePanel("Welcom to Java");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new CheckBoxDemo();
		frame.setTitle("Milo SB");
		frame.setSize(500,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public CheckBoxDemo(){
		jchkCentered.setMnemonic('C');
		jchkBold.setMnemonic('B');
		jchkItalic.setMnemonic('I');
		
		JPanel jpCheckBoxes = new JPanel();
		jpCheckBoxes.setLayout(new GridLayout(3,1));
		jpCheckBoxes.add(jchkCentered);
		jpCheckBoxes.add(jchkBold);
		jpCheckBoxes.add(jchkItalic);
		add(messagePanel,BorderLayout.CENTER);
		add(jpCheckBoxes,BorderLayout.EAST);
		
		jchkCentered.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messagePanel.setCentered(jchkCentered.isSelected());
			}
		});
		jchkBold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setNewFont();
			}
		});
		jchkItalic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setNewFont();
			}
		});
	}
	
	private void setNewFont(){
		int fontStyle = Font.PLAIN;
		fontStyle += (jchkBold.isSelected())? Font.BOLD : Font.PLAIN;
		fontStyle += (jchkItalic.isSelected())? Font.ITALIC : Font.PLAIN;
		
		Font font = messagePanel.getFont();
		messagePanel.setFont(new Font(font.getName(),fontStyle,font.getSize()));
	}

}
