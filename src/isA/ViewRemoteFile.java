package isA;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewRemoteFile extends JFrame {
	private JButton jbtView = new JButton("View");
	private JTextField jtfURL = new JTextField(12);
	private JTextArea jtaFile = new JTextArea();
	private JLabel jlblStatus = new JLabel();
	
	public ViewRemoteFile(){
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Filename"),BorderLayout.WEST);
		p1.add(jtfURL, BorderLayout.CENTER);
		p1.add(jbtView,BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(jtaFile),BorderLayout.CENTER);
		add(p1,BorderLayout.NORTH);
		add(jlblStatus,BorderLayout.SOUTH);
		
		jbtView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showFile();
			}
		});
	}
	
	private void showFile() {
		Scanner input = null;
		URL url = null;
		
		try {
			url = new URL(jtfURL.getText().trim());
			
			input = new Scanner(url.openStream());
			
			while (input.hasNext()) {
				jtaFile.append(input.nextLine() + '\n');
			}
			
			jlblStatus.setText("File Loaded Successfully");
		} catch (MalformedURLException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} finally{
			if(input != null) input.close();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ViewRemoteFile();
		frame.setTitle("Milo SB");
		frame.setSize(800,600);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
