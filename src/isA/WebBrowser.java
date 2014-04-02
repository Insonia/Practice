package isA;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import HelloWorld.AdditionQuize;

public class WebBrowser extends JFrame {
	private JEditorPane jep = new JEditorPane();
	private JLabel jlbUrl = new JLabel("URL");
	private JTextField jtfURL = new JTextField();
	
	public WebBrowser(){
		JPanel jpURL = new JPanel();
		jpURL.setLayout(new BorderLayout());
		jpURL.add(jlbUrl,BorderLayout.WEST);
		jpURL.add(jtfURL,BorderLayout.CENTER);
		
		add(new JScrollPane(jep),BorderLayout.CENTER);
		add(jpURL,BorderLayout.NORTH);
		
		jep.setEditable(false);
		
		jep.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				try {
					jep.setPage(e.getURL());
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		});
		
		jtfURL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(jtfURL.getText().trim());
					
					jep.setPage(url);
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new WebBrowser();
		frame.setTitle("Milo SB");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
