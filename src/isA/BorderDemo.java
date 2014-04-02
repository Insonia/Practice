package isA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderDemo extends JFrame {
	private JLabel jLabel1 = new JLabel("Display the border type", JLabel.CENTER);
	private JCheckBox jchkTitled;
	private JRadioButton jrbLoweredBevel, jrbRaisedBevel, jrbEteched, jrbLine, jrbMatte, jrbEmpty;
	private JRadioButton jrbAboveBottom, jrbBottom, jrbBelowBottom, jrbAboveTop, jrbTop, jrbBelowTop, jrbLeft, jrbCenter, jrbRight;
	
	private TitledBorder jLabelBorder;
	
	public BorderDemo(){
		jLabel1.setBackground(Color.yellow);
		jLabel1.setBorder(jLabelBorder);
		
		JPanel jpPostion = new JPanel();
		jpPostion.setLayout(new GridLayout(3,2));
		jpPostion.add(jrbAboveBottom = new JRadioButton("ABOVE_BOTTOM"));
		jpPostion.add(jrbAboveTop = new JRadioButton("ABOVE_TOP"));
		jpPostion.add(jrbTop = new JRadioButton("TOP"));
		jpPostion.add(jrbBottom = new JRadioButton("BOTTOM"));
		jpPostion.add(jrbBelowBottom = new JRadioButton("BELOW_BOTTOM"));
		jpPostion.add(jrbBelowTop = new JRadioButton("BELOW_TOP"));
		jpPostion.setBorder(new TitledBorder("Position"));
		
		JPanel jpJustifaction = new JPanel();
		jpJustifaction.setLayout(new GridLayout(3,1));
		jpJustifaction.add(jrbLeft = new JRadioButton("LEFT"));
		jpJustifaction.add(jrbCenter = new JRadioButton("CENTER"));
		jpJustifaction.add(jrbRight = new JRadioButton("RIGHT"));
		jpJustifaction.setBorder(new TitledBorder("Justifaction"));
		
		JPanel jpTitleOption =new JPanel();
		jpTitleOption.setLayout(new BorderLayout());
		jpTitleOption.add(jpPostion,BorderLayout.CENTER);
		jpTitleOption.add(jpJustifaction,BorderLayout.EAST);
		
		JPanel jpTitle = new JPanel();
		jpTitle.setBorder(new TitledBorder("Title Border"));
		jpTitle.setLayout(new BorderLayout());
		jpTitle.add(jchkTitled = new JCheckBox("Titled"),BorderLayout.NORTH);
		jpTitle.add(jpTitleOption,BorderLayout.CENTER);
		
		ButtonGroup btgTitlePosition = new ButtonGroup();
		btgTitlePosition.add(jrbAboveBottom);
		btgTitlePosition.add(jrbBottom);
		btgTitlePosition.add(jrbBelowBottom);
		btgTitlePosition.add(jrbAboveTop);
		btgTitlePosition.add(jrbTop);
		btgTitlePosition.add(jrbBelowTop);
		
		ButtonGroup btgTitleJustification = new ButtonGroup();
		btgTitleJustification.add(jrbLeft);
		btgTitleJustification.add(jrbCenter);
		btgTitleJustification.add(jrbRight);
		
		JPanel jpBorderStyle = new JPanel();
		jpBorderStyle.setBorder(new TitledBorder("Border Style"));
		jpBorderStyle.setLayout(new GridLayout(6,1));
		jpBorderStyle.add(jrbLoweredBevel = new JRadioButton("Lowered Bevel"));
		jpBorderStyle.add(jrbRaisedBevel = new JRadioButton("Rasied Bevel"));
		jpBorderStyle.add(jrbEteched = new JRadioButton("Eteched"));
		jpBorderStyle.add(jrbLine = new JRadioButton("LIne"));
		jpBorderStyle.add(jrbMatte = new JRadioButton("Matte"));
		jpBorderStyle.add(jrbEmpty = new JRadioButton("Empty"));
		
		ButtonGroup btgBorderStyle = new ButtonGroup();
		btgBorderStyle.add(jrbLoweredBevel);
		btgBorderStyle.add(jrbRaisedBevel);
		btgBorderStyle.add(jrbEteched);
		btgBorderStyle.add(jrbLine);
		btgBorderStyle.add(jrbMatte);
		btgBorderStyle.add(jrbEmpty);
		
		JPanel jpAllChoices = new JPanel();
		jpAllChoices.setLayout(new BorderLayout());
		jpAllChoices.add(jpTitle,BorderLayout.CENTER);
		jpAllChoices.add(jpBorderStyle,BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(jLabel1,BorderLayout.CENTER);
		add(jpAllChoices,BorderLayout.SOUTH);
		
		ActionListener listener = new EventListener(); //TODO
		jchkTitled.addActionListener(listener);
		jrbAboveBottom.addActionListener(listener);
		jrbBottom.addActionListener(listener);
		jrbBelowBottom.addActionListener(listener);
		jrbAboveTop.addActionListener(listener);
		jrbTop.addActionListener(listener);
		jrbBelowTop.addActionListener(listener);
		jrbLeft.addActionListener(listener);
		jrbCenter.addActionListener(listener);
		jrbRight.addActionListener(listener);
		jrbLoweredBevel.addActionListener(listener);
		jrbRaisedBevel.addActionListener(listener);
		jrbLine.addActionListener(listener);
		jrbEteched.addActionListener(listener);
		jrbMatte.addActionListener(listener);
		jrbEmpty.addActionListener(listener);
		
	}
	
	private class EventListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Border border = new EmptyBorder(2, 2,2,2);
			if(jrbLoweredBevel.isSelected()){
				border = new BevelBorder(BevelBorder.LOWERED);
				jLabel1.setText("Lowered Bevel Style");
			}
			else if (jrbRaisedBevel.isSelected()) {
				border = new BevelBorder(BevelBorder.RAISED);
				jLabel1.setText("Rasied Bevel Style");
			}
			else if (jrbEteched.isSelected()) {
				border = new EtchedBorder();
				jLabel1.setText("Etched Style");
			}
			else if (jrbLine.isSelected()) {
				border = new LineBorder(Color.black,5);
				jLabel1.setText("Line Style");
			}
			else if (jrbMatte.isSelected()) {
				border = new MatteBorder(new ImageIcon("imag/1.png"));
				jLabel1.setText("Matte Style");
			}
			else if (jrbEmpty.isSelected()) {
				border = new EmptyBorder(2, 2, 2, 2);
				jLabel1.setText("Empty Style");
			}
			
			if(jchkTitled.isSelected()){
				int titlePosition = TitledBorder.DEFAULT_POSITION;
				int titleJustifacation = TitledBorder.DEFAULT_JUSTIFICATION;
				
				if (jrbAboveBottom.isSelected()) 
					titlePosition = TitledBorder.ABOVE_BOTTOM;
				else if(jrbBottom.isSelected())
					titlePosition = TitledBorder.BOTTOM;
				else if(jrbBelowBottom.isSelected())
					titlePosition = TitledBorder.BELOW_BOTTOM;
				else if(jrbAboveTop.isSelected())
					titlePosition = TitledBorder.ABOVE_TOP;
				else if(jrbTop.isSelected())
					titlePosition = TitledBorder.TOP;
				else if(jrbBelowTop.isSelected())
					titlePosition = TitledBorder.BELOW_TOP;
				
				if(jrbLeft.isSelected())
					titleJustifacation = TitledBorder.LEFT;
				else if(jrbCenter.isSelected())
					titleJustifacation = TitledBorder.CENTER;
				else if(jrbRight.isSelected())
					titleJustifacation = TitledBorder.RIGHT;
				
				jLabelBorder  = new TitledBorder("A Title");
				jLabelBorder.setBorder(border);
				jLabelBorder.setTitlePosition(titlePosition);
				jLabelBorder.setTitleJustification(titleJustifacation);
				jLabel1.setBorder(jLabelBorder);
			}
			else {
				jLabel1.setBorder(border);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new BorderDemo();
		//frame.pack();
		frame.setSize(500,300);
		frame.setVisible(true);
	}

}
