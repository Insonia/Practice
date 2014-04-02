package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListPropertiesDemo extends JFrame {
	private JList jlst= new JList(new String[] {"Item1","Item2","Item3","Item4","Item5","Item6"});
	private JSpinner jspVisibleRowCount = new JSpinner(new SpinnerNumberModel(8, -1, 20, 1));
	private JComboBox jcboLayoutOrientation = new JComboBox(new String[]{"VERTICAL(0)","VERTICAL_WRAP(1)","HORIZONTAL_WRAP(2)"});
	private JComboBox jcboSelectionMode = new JComboBox(new String[]{"SINGLE_SELECTION(0)","SINGLE_INTERVAL_SELECTION(1)",
			"MUTIPLE_INTERVAL_SELECTION(2)"});
	private JLabel jlbStatus = new JLabel();
	
	public ListPropertiesDemo(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,1));
		panel1.add(new JLabel("VisbleRowCount"));
		panel1.add(new JLabel("layoutOrientation"));
		panel1.add(new JLabel("selectionMOde"));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(jspVisibleRowCount);
		panel2.add(jcboLayoutOrientation);
		panel2.add(jcboSelectionMode);
		
		JPanel panel3 = new JPanel();
		panel3.add(panel1,BorderLayout.WEST);
		panel3.add(panel2,BorderLayout.CENTER);
		
		add(panel3,BorderLayout.NORTH);
		add(new JScrollPane(jlst),BorderLayout.CENTER);
		add(jlbStatus,BorderLayout.SOUTH);
		
		jlst.setFixedCellWidth(50);
		jlst.setFixedCellHeight(20);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jspVisibleRowCount.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jlst.setVisibleRowCount(((Integer)jspVisibleRowCount.getValue()).intValue());
			}
		});
		
		jcboLayoutOrientation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlst.setLayoutOrientation(jcboLayoutOrientation.getSelectedIndex());
			}
		});
		
		jcboSelectionMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlst.setSelectionMode(jcboSelectionMode.getSelectedIndex());
			}
		});
		
		jlst.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Object[] values = jlst.getSelectedValues();
				String display = "";
				
				for(int i = 0 ; i < values.length; i ++)
					display += (String)values[i];
				
				jlbStatus.setText(display);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ListPropertiesDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
