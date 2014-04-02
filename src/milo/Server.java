package milo;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame {
	private JTextArea jta = new JTextArea();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}
	
	public Server(){
		setLayout(new BorderLayout());
		add(new JScrollPane(jta),BorderLayout.CENTER);
		
		setTitle("Server");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("Server started at " + new Date() + '\n');
			
			Socket socket = serverSocket.accept();
			
			DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
			
			while (true) {
				double radius = inputFromClient.readDouble();
				double area = radius * radius * Math.PI;
				
				outputToClient.writeDouble(area);
				
				jta.append("radius received from cilent: " + radius + '\n');
				jta.append("Area found: " + area + '\n');
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
