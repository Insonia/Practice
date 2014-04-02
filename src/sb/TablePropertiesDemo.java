package sb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TablePropertiesDemo extends JFrame {
	private String[] columNameStrings = {"Country", "Capital", "Population","Democracy"};
	private Object[][] dataObjects = {
			{"USA","Washington,DC",280,true},
			{"Canda","Tttawa",32,true},
			{"Untied","Lodon",60,true},
			{"Germany","Berlin",83,true}
	};
	
	private JTable jTable = new JTable(dataObjects,columNameStrings);
	
	private JSpinner jspiRowHeight = new JSpinner(new SpinnerNumberModel(16, 1, 50, 1));
	private JSpinner jspiRowMargin = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
	
	private JCheckBox jchkShowGrid = new JCheckBox("ShowGrid",true);
	
	private JComboBox jcboAutoResizeMode = new JComboBox(new String[]{"AUTO_RESIZE_OFF","AUTO_RESIZE_LAST_COLUM",
		"AUTO_RESIZE_SUBSEQUENT_COLUMN","AUTO_RESIZE_NEXT_COLUMN","AUTO_RESIZE_ALL_COLUMN"});
	
	public TablePropertiesDemo(){
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("rowHeight"));
		panel1.add(jspiRowHeight);
		panel1.add(new JLabel("rowMargin"));
		panel1.add(jspiRowMargin);
		panel1.add(jchkShowGrid);
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("autoResizedMode"));
		panel2.add(jcboAutoResizeMode);
		
		add(panel1,BorderLayout.SOUTH);
		add(panel2,BorderLayout.NORTH);
		add(new JScrollPane(jTable));
		
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setGridColor(Color.blue);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.setSelectionBackground(Color.red);
		
		jspiRowHeight.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jTable.setRowHeight(((Integer)(jspiRowHeight.getValue())).intValue());
			}
		});
		
		jspiRowMargin.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jTable.setRowMargin(((Integer)(jspiRowMargin.getValue())).intValue());
			}
		});
		
		jchkShowGrid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTable.setShowGrid(jchkShowGrid.isSelected());
			}
		});
		
		jcboAutoResizeMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String selectedItem = (String)jcboAutoResizeMode.getSelectedItem();
				
				if(selectedItem.equals("AUTO_RESIZE_OFF"))
					jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				else if(selectedItem.equals("AUTO_RESIZE_LAST_COLUM"))
					jTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				else if(selectedItem.equals("AUTO_RESIZE_SUBSEQUENT_COLUMN"))
					jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				else if(selectedItem.equals("AUTO_RESIZE_NEXT_COLUMN"))
					jTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				else if(selectedItem.equals("AUTO_RESIZE_ALL_COLUMN"))
					jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TablePropertiesDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
