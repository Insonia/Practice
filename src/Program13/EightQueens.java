package Program13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EightQueens extends JFrame {
	public static final int SIZE = 8;
	private int[] queens = new int[SIZE];
	
	public EightQueens(){
		search(0);
		add(new CHessBoard(),BorderLayout.CENTER);
	}
	
	private boolean isValid(int row, int column){
		for(int i= 1; i<= row; i++)
			if(queens[row - i] == column || queens[row - i] == column - i || queens[row - i] ==column + i)
				return false;
		return true;
	}
	
	private boolean search(int row){
		if(row == SIZE)
			return true;
		for(int column = 0; column < SIZE; column ++){
			queens[row] = column;
			if(isValid(row, column) && search(row + 1))
				return true;
		}
		
		return false;
	}
	
	class CHessBoard extends JPanel{
		private Image queenImage = new ImageIcon("crown.png").getImage();
		
		CHessBoard(){
			this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i< SIZE; i++){
				int j= queens[i];
				g.drawImage(queenImage, j*getWidth()/SIZE, i*getHeight()/SIZE, getWidth()/SIZE, getHeight()/SIZE, this);
			}
			
			for(int i=1;i<SIZE;i++){
				g.drawLine(0, i*getHeight()/SIZE, getWidth(), i*getHeight()/SIZE);
				g.drawLine(i*getWidth()/SIZE, 0, i*getWidth()/SIZE, getHeight());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new EightQueens();
		frame.setTitle("Milo SB");
		frame.setSize(200,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
