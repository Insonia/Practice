package isA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.CellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TicTacToeClient extends JFrame implements Runnable, TicTacToeConstants { 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TicTacToeClient();
		frame.setTitle("Milo SB");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private boolean myTurn = false;
	
	private char myToken = ' ';
	private char otherToken = ' ';
	
	private Cell[][] cell = new Cell[3][3];
	private JLabel jlbTitle = new JLabel();
	private JLabel jlbStatus = new JLabel();
	
	private int rowSelected;
	private int columnSelected;
	
	private DataInputStream fromServer;
	private DataOutputStream toServer;
	
	private boolean continueToPlay = true;
	
	private boolean waiting = true;
	
	//private boolean isStandAlone = false;
	
	private String host = "192.168.0.162";
	
	public TicTacToeClient() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,3,0,0));
		for(int i = 0 ; i< 3; i++)
			for(int j = 0; j < 3; j++)
				p.add(cell[i][j] = new Cell(i, j));
		
		p.setBorder(new LineBorder(Color.black,1));
		jlbTitle.setHorizontalAlignment(JLabel.CENTER);
		jlbTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		jlbTitle.setBorder(new LineBorder(Color.black,1));
		jlbStatus.setBorder(new LineBorder(Color.black,1));
		
		add(jlbTitle,BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(jlbStatus,BorderLayout.SOUTH);
		
		connectToServer();
				//asdasd
	}
	
	private void connectToServer(){
		try {
			Socket socket;
			socket = new Socket(host,8000);
			
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
//			if(isStandAlone)
//				socket = new Socket(host,8000);
//			else
//				socket = new Socket()
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int player = fromServer.readInt();
			
			if(player == PLAYER1){
				myToken = 'X';
				otherToken = '0';
				jlbTitle.setText("Player 1 with 'X'");
				jlbStatus.setText("Waiting for player 2 to join");
				
				fromServer.readInt();
				
				jlbStatus.setText("Player 2 has Joined. I start first");
				
				myTurn = true;
			}else if (player == PLAYER2) {
				myToken = '0';
				otherToken = 'X';
				jlbTitle.setText("Player 2 with token '0'");
				jlbStatus.setText("Waiting for player 1 to move");
			}
			
			while (continueToPlay) {
				if(player == PLAYER1){
					waitForPlayerAction();
					sendMove();
					receiveInfoFromServer();
				}else if (player == PLAYER2) {
					receiveInfoFromServer();
					waitForPlayerAction();
					sendMove();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void waitForPlayerAction() throws InterruptedException{
		while (waiting) {
			Thread.sleep(100);
		}
		
		waiting = true;
	}
	
	private void sendMove() throws IOException{
		toServer.writeInt(rowSelected);
		toServer.writeInt(columnSelected);
	}
	
	private void receiveInfoFromServer()throws IOException {
		int status = fromServer.readInt();
		
		if(status == PLAYER1_WON){
			continueToPlay = false;
			if(myToken== 'X'){
				jlbStatus.setText("I WON! (X)");
			}else if (myToken == '0') {
				jlbStatus.setText("Player 1 (X) has won!");
				receiveMove();
			}
		}else if (status == PLAYER2_WON) {
			continueToPlay = false;
			if(myToken == '0')
				jlbStatus.setText("I Won! (0)");
			else if (myToken == 'X') {
				jlbStatus.setText("Player 2 (0) has won");
				receiveMove();
			}
		}else if (status == DRAW) {
			continueToPlay = false;
			jlbStatus.setText("Game is ove, no winner");
			
			if(myToken == '0')
				receiveMove();
		}else {
			receiveMove();
			jlbStatus.setText("My Turn");
			myTurn = true;
		}
	}
	
	private void receiveMove() throws IOException{
		int row = fromServer.readInt();
		int column = fromServer.readInt();
		cell[row][column].setToken(otherToken);
		
	}
	
	public class Cell extends JPanel{
		private int row;
		private int colum;
		
		private char token= ' ';
		
		public Cell(int row, int colum){
			this.row = row;
			this.colum  = colum;
			setBorder(new LineBorder(Color.black,1));
			addMouseListener(new ClickListener());
		}
		
		public char getToken(){
			return token;
		}
		
		public void setToken(char c){
			token = c;
			repaint();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(token == 'X'){
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}else if (token == '0') {
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}
		
		private class ClickListener extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				if((token == ' ')&&myTurn){
					setToken(myToken);
					myTurn = false;
					rowSelected = row;
					columnSelected = colum;
					jlbStatus.setText("Waiting foe the other player to move");
					waiting = false;
				}
			}
		}
	}

}
