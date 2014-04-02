package milo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlashingText extends JFrame implements Runnable {
	private JLabel jlbText = new JLabel("Welcome to Java");
	
	public FlashingText(){
		add(jlbText);
		new Thread(this).start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new FlashingText();
		frame.setTitle("Milo SB");
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				if(jlbText.getText() == null)
					jlbText.setText("Welcome to Java");
				else {
					jlbText.setText(null);
				}
				
				Thread.sleep(200);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
