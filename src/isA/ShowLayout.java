package isA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ShowLayout extends JFrame {
	private String flowLayoutDesc = "FlowLayout asjkdjsahfiahdgfdhgdfhgdkfsjhgjkahsdjgsahdjfgsdhdfjlghdlsfhgjdsfhghsdhfgshdiufgasdgyasd";
	private String gridLayoutDesc = "GridLayout asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
	private String boxLayoutDesc = "BoxLayout dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
	
	private JRadioButton jrbFlowLayout = new JRadioButton("FlowLayout");
	private JRadioButton jrbGridLayout = new JRadioButton("GridLayout",true);
	private JRadioButton jrbBoxLayout = new JRadioButton("BoxLayout");
	
	private JPanel jpComponent  = new JPanel();
	private JTextArea jtaDesc = new JTextArea();
	
	private FlowLayout flowLayout = new FlowLayout();
	private GridLayout gridLayout = new GridLayout(2,2,3,3);
	private BoxLayout boxLayout = new BoxLayout(jpComponent,BoxLayout.X_AXIS);
	
	public ShowLayout(){
		Box jpChooseLayout = Box.createVerticalBox();
		jpChooseLayout.add(jrbFlowLayout);
		jpChooseLayout.add(jrbGridLayout);
		jpChooseLayout.add(jrbBoxLayout);
		
		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbBoxLayout);
		btg.add(jrbGridLayout);
		btg.add(jrbFlowLayout);
		
		jtaDesc.setLineWrap(true);
		jtaDesc.setWrapStyleWord(true);
		
		jpComponent.add(new JButton("Button 1"));
		jpComponent.add(new JButton("Button 2"));
		jpComponent.add(new JButton("Button 3"));
		jpComponent.add(new JButton("Button 4"));
		
		JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jpComponent,new JScrollPane(jtaDesc));
		JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpChooseLayout,jSplitPane2);
		
		jpComponent.setLayout(flowLayout);
		jpComponent.revalidate();
		jtaDesc.setText(flowLayoutDesc);
		
		add(jSplitPane1,BorderLayout.CENTER);
		
		jrbBoxLayout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jpComponent.setLayout(boxLayout);
				jpComponent.revalidate();
				jtaDesc.setText(boxLayoutDesc);
			}
		});
		
		jrbFlowLayout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jpComponent.setLayout(flowLayout);
				jpComponent.revalidate();
				jtaDesc.setText(flowLayoutDesc);
			}
		});
		
		jrbGridLayout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jpComponent.setLayout(gridLayout);
				jpComponent.revalidate();
				jtaDesc.setText(gridLayoutDesc);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ShowLayout();
		frame.setTitle("Milo SB");
		frame.setSize(400,400);
		frame.setVisible(true);
	}

}
