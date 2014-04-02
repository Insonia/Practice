package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimpleTreeDemo extends JFrame {
	private JTree jTree1 = new JTree();
	
	private JTree jTree2 = new JTree(new String[]{"dog","pig","cat","fuck","milo","is","sb"});
	private Vector vector = new Vector(Arrays.asList(new Object[]{"balck","red","green","blue","black"}));
	private JTree jTree3 = new JTree(vector);
	
	private Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
	private JTree jTree4;
	
	private JComboBox jcboRootvisible = new JComboBox(new String[] {"false","true"});
	
	private JComboBox jcboShowRootHandles= new JComboBox(new String[] {"false","true"});
	
	private JSpinner jSpinnerRowHight = new JSpinner(new SpinnerNumberModel(16, 1, 50, 1));
	
	public SimpleTreeDemo(){
		jTree1.setRootVisible(false);
		
		hashtable.put(1, "red");
		hashtable.put(2, "green");
		hashtable.put(3, "blue");
		hashtable.put(4, "yellow");
		jTree4 = new JTree(hashtable);
		
		JPanel panel1 = new JPanel(new GridLayout(1,4));
		panel1.add(new JScrollPane(jTree1));
		panel1.add(new JScrollPane(jTree2));
		panel1.add(new JScrollPane(jTree3));
		panel1.add(new JScrollPane(jTree4));
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("rootVisible"));
		panel2.add(jcboRootvisible);
		panel2.add(new JLabel("rowHeight"));
		panel2.add(jSpinnerRowHight);
		panel2.add(new JLabel("ShowRootHandles"));
		panel2.add(jcboShowRootHandles);
		
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
		jcboRootvisible.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean rootVisible = jcboRootvisible.getSelectedItem().equals("true");
				jTree1.setRootVisible(rootVisible);
				jTree2.setRootVisible(rootVisible);
				jTree3.setRootVisible(rootVisible);
				jTree4.setRootVisible(rootVisible);
			}
		});
		
		jcboShowRootHandles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean showRootHandles = jcboShowRootHandles.getSelectedItem().equals("true");
				jTree1.setShowsRootHandles(showRootHandles);
				jTree2.setShowsRootHandles(showRootHandles);
				jTree3.setShowsRootHandles(showRootHandles);
				jTree4.setShowsRootHandles(showRootHandles);
			}
		});
		
		jSpinnerRowHight.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int height = ((Integer)(jSpinnerRowHight.getValue())).intValue();
				jTree1.setRowHeight(height);
				jTree2.setRowHeight(height);
				jTree3.setRowHeight(height);
				jTree4.setRowHeight(height);
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SimpleTreeDemo();
		frame.pack();
		frame.setVisible(true);
	}
}
