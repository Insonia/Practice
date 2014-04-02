package sb;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimpleSpinner extends JFrame{
	private JSpinner spinner = new JSpinner();
	
	private JLabel label = new JLabel("",JLabel.CENTER);
	
	public SimpleSpinner(){
		add(spinner,BorderLayout.NORTH);
		add(label,BorderLayout.CENTER);
		
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				label.setText("previous vlaue " + spinner.getPreviousValue()
						+ " Current value: " + spinner.getValue()
						+ " Next value: " + spinner.getNextValue());
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SimpleSpinner();
		frame.pack();
		frame.setVisible(true);
	}

}
