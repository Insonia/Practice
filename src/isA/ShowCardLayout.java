package isA;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ShowCardLayout extends JFrame {
	private CardLayout cardLayout = new CardLayout(20,10);
	private JPanel cardPanel = new JPanel(cardLayout);
	private JButton jbtFirst, jbtNext, jbtPrevious, jbtLast;
	private JComboBox jcboImage;
	private final int NUM_OF_FLAGS = 3;
	
	public ShowCardLayout(){
		cardPanel.setBorder(new LineBorder(Color.red));
		
		for(int i= 1; i<= NUM_OF_FLAGS; i++){
			JLabel label = new JLabel(new ImageIcon("imag/flag" + i + ".png"));
			cardPanel.add(label,String.valueOf(i));
		}
		
		JPanel p =new JPanel();
		p.add(jbtFirst = new JButton("First"));
		p.add(jbtNext = new JButton("Next"));
		p.add(jbtPrevious = new JButton("Previous"));
		p.add(jbtLast = new JButton("Last"));
		p.add(new JLabel("Image"));
		p.add(jcboImage = new JComboBox());
		
		for(int i = 1;i<= NUM_OF_FLAGS; i++)
			jcboImage.addItem(String.valueOf(i));
		
		add(cardPanel,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		jbtFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.first(cardPanel);
			}
		});
		
		jbtNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.next(cardPanel);
			}
		});
		
		jbtPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.previous(cardPanel);
			}
		});
		
		jbtLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.last(cardPanel);
			}
		});
		
		jcboImage.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(cardPanel, (String)e.getItem());
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ShowCardLayout();
		frame.setTitle("Milo SB");
		frame.setSize(400,300);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
