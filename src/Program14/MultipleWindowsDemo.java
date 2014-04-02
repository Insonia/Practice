package Program14;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultipleWindowsDemo extends JFrame {
	private JTextArea jta;
	private JButton jbtShowHistogram = new JButton("Show Histogram");
	private HIstogram hIstogram = new HIstogram();
	
	private JFrame histogramFrame = new JFrame();
	
	public MultipleWindowsDemo(){
		JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
		scrollPane.setPreferredSize(new Dimension(300, 200));
		jta.setWrapStyleWord(true);
		jta.setLineWrap(true);
		
		add(scrollPane,BorderLayout.CENTER);
		add(jbtShowHistogram,BorderLayout.SOUTH);
		
		jbtShowHistogram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count[] = countLetters();
				
				hIstogram.showHistogram(count);
				histogramFrame.setVisible(true);
			}
		});
		
		histogramFrame.add(hIstogram);
		histogramFrame.pack();
		histogramFrame.setTitle("Milo SB");
	}
	
	private int[] countLetters() {
		int[] count = new int[26];
		
		String textString = jta.getText();
		
		for(int i = 0; i< textString.length(); i++){
			char character = textString.charAt(i);
			if((character >= 'A') && (character <= 'Z')){
				count[character - 'A'] ++;
			}else if ((character >= 'a') && (character <= 'z')) {
				count[character - 'a'] ++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MultipleWindowsDemo();
		frame.setLocationRelativeTo(null);
		frame.setTitle("Milo SB");
		frame.pack();
		frame.setVisible(true);
	}

}
