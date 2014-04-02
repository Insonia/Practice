package milo;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MultiThreadServer extends JFrame {
	private JTextArea jta = new JTextArea();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiThreadServer();
	}
	
	public MultiThreadServer(){
		setLayout(new BorderLayout());
		add(new JScrollPane(jta),BorderLayout.CENTER);
		
		setTitle("Server");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("MultiThreadServer started at " + new Date() + '\n');
			
			int clientNo = 1;
			
			while(true){
				Socket socket = serverSocket.accept();
				
				jta.append("Starting thread for clint " + clientNo + " at " + new Date() + '\n');
				
				InetAddress inetAddress = socket.getInetAddress();
				jta.append("Client " + clientNo + "'s host name is " + inetAddress.getHostName());
				jta.append("Client " + clientNo + "'s IP address is " + inetAddress.getHostAddress());
				
				HandleAClient task = new HandleAClient(socket);
				
				new Thread(task).run();
				clientNo++;
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	class HandleAClient implements Runnable{
		private Socket socket;
		
		public HandleAClient(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				DataInputStream inputFromClinet = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				while(true){
					double radius = inputFromClinet.readDouble();
					
					double area = radius * radius * Math.PI;
					
					outputToClient.writeDouble(area);
					
					jta.append("Radius received from client: " + radius + '\n');
					jta.append("Area found: " + area + '\n');
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
