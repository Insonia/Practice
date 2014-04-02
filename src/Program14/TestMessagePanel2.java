package Program14;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestMessagePanel2 extends JFrame {
	public TestMessagePanel2(){
		MessagePanel messagePanel1 = new MessagePanel("Welcome to Java",true);
		MessagePanel messagePanel2 = new MessagePanel("Java is Fun",true);
		MessagePanel messagePanel3 = new MessagePanel("Java is cool",true);
		MessagePanel messagePanel4 = new MessagePanel("I love Java",true);
		
		messagePanel1.setFont(new Font("SansSerif",Font.ITALIC,15));
		messagePanel2.setFont(new Font("Courier",Font.BOLD,20));
		messagePanel3.setFont(new Font("Times",Font.ITALIC,20));
		messagePanel4.setFont(new Font("Californian FB",Font.PLAIN,20));
		
		messagePanel1.setBackground(Color.red);
		messagePanel2.setBackground(Color.cyan);
		messagePanel3.setBackground(Color.green);
		messagePanel4.setBackground(Color.white);
		
		setLayout(new GridLayout(2,2));
		add(messagePanel1);
		add(messagePanel2);
		add(messagePanel3);
		add(messagePanel4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestMessagePanel2();
		frame.setTitle("Milo SB");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
