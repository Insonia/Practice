package Program14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HandleEvent extends JFrame {
	public HandleEvent(){
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");
		
		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		
		add(panel);
		
		OKListenerClass listener1 = new OKListenerClass();
		CancelListenerClass listener2 = new CancelListenerClass();
		jbtOK.addActionListener(listener1);
		jbtCancel.addActionListener(listener2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new HandleEvent();
		frame.setTitle("Milo SB");
		frame.setSize(200,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class OKListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("OK button clicked.");
	}
}

class CancelListenerClass implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Cancle button clicked.");
	}
	
}