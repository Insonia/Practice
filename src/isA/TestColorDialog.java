package isA;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestColorDialog extends JFrame {
	private ColorDialog colorDialog = new ColorDialog();
	private JButton jbtChangeColor = new JButton("Choose Color");
	
	public TestColorDialog(){
		setLayout(new FlowLayout());
		add(jbtChangeColor);
		jbtChangeColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorDialog.setVisible(true);
				if(colorDialog.getColor() != null)
					jbtChangeColor.setForeground(colorDialog.getColor());
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestColorDialog();
		frame.setVisible(true);
	}

}
