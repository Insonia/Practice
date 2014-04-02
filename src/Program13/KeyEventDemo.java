package Program13;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.PRIVATE_MEMBER;

public class KeyEventDemo extends JFrame {
	private KeybordPanel keyboardPanle = new KeybordPanel();
	
	public KeyEventDemo(){
		add(keyboardPanle);
		keyboardPanle.setFocusable(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new KeyEventDemo();
		frame.setTitle("Milo SB");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class KeybordPanel extends JPanel{
		private int x = 100;
		private int y = 100;
		private char keyChar = 'A';
		
		public KeybordPanel(){
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_DOWN:
						y+=10;
						break;
					case KeyEvent.VK_UP:
						y-=10;
						break;
					case KeyEvent.VK_LEFT:
						x-=10;
						break;
					case KeyEvent.VK_RIGHT:
						x+=10;
						break;
					default:
						keyChar = e.getKeyChar();
					}
					
					repaint();
				}
			});
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(String.valueOf(keyChar), x, y);
		}
	}
}
