package Program14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonDemo extends JFrame {
	
	protected MessagePanel messagePanel = new MessagePanel("Welcome to Java");
	
	private JButton jbtLeftButton = new JButton("<=");
	private JButton jbtRightButton = new JButton("=>");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ButtonDemo();
		frame.setTitle("Milo SB");
		frame.setSize(250,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ButtonDemo(){
		
		messagePanel.setBackground(Color.white);
		
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtLeftButton);
		jpButtons.add(jbtRightButton);
		
		jbtLeftButton.setMnemonic('L');
		jbtRightButton.setMnemonic('R');
		
		jbtLeftButton.setToolTipText("Move message to Left");
		jbtRightButton.setToolTipText("Move message to right");
		
		setLayout(new BorderLayout());
		add(messagePanel, BorderLayout.CENTER);
		add(jpButtons,BorderLayout.SOUTH);
		
		jbtLeftButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messagePanel.moveLeft();
			}
		});
		
		jbtRightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messagePanel.moveRight();
			}
		});
	}

}
