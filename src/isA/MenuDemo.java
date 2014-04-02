package isA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MenuDemo extends JFrame {
	private JTextField jtfNum1, jtfNum2, jtfResult;
	private JButton jbtAdd, jbtSub, jbtDiv, jbtMul;
	private JMenuItem jmiAdd, jmiSun,jmiDiv,jmiMul,jmiClose;
	
	public MenuDemo(){
		JMenuBar jmb = new JMenuBar();
		
		setJMenuBar(jmb);
		
		JMenu operationMenu = new JMenu("Operation");
		operationMenu.setMnemonic('0');
		jmb.add(operationMenu);
		
		JMenu exitMenu = new JMenu("Exit");
		exitMenu.setMnemonic('E');
		jmb.add(exitMenu);
		
		operationMenu.add(jmiAdd = new JMenuItem("Add",'A'));
		operationMenu.add(jmiSun = new JMenuItem("Sub",'S'));
		operationMenu.add(jmiDiv = new JMenuItem("Div",'D'));
		operationMenu.add(jmiMul = new JMenuItem("Mul",'M'));
		exitMenu.add(jmiClose = new JMenuItem("Exit",'E'));
		
		jmiAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		jmiSun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jmiDiv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		jmiMul.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(new JLabel("Number 1"));
		p1.add(jtfNum1 = new JTextField(3));
		p1.add(new JLabel("Number 2"));
		p1.add(jtfNum2 = new JTextField(3));
		p1.add(new JLabel("Result"));
		p1.add(jtfResult = new JTextField(4));
		jtfResult.setEditable(false);
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(jbtAdd = new JButton("Add"));
		p2.add(jbtSub = new JButton("Sub"));
		p2.add(jbtDiv = new JButton("Dvi"));
		p2.add(jbtMul = new JButton("Mul"));
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		jbtAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('+');
			}
		});
		
		jbtDiv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('/');
			}
		});
		
		jbtSub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('-');
			}
		});
		
		jbtMul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('*');
			}
		});
		
		jmiAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('+');
			}
		});
		
		jmiSun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('-');
			}
		});
		
		jmiDiv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('/');
			}
		});
		
		jmiMul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculate('*');
			}
		});
		
		jmiClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	private void calculate(char ch) {
		int num1 = Integer.parseInt(jtfNum1.getText().trim());
		int num2 = Integer.parseInt(jtfNum2.getText().trim());
		int result = 0;
		
		switch (ch) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		default:
			break;
		}
		
		jtfResult.setText(result + "");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MenuDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
