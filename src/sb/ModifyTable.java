package sb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ModifyTable extends JFrame{
	private String[] columNameStrings = {"Country", "Capital", "Population","Democracy"};
	private Object[][] dataObjects = {
			{"USA","Washington,DC",280,true},
			{"Canda","Tttawa",32,true},
			{"Untied","Lodon",60,true},
			{"Germany","Berlin",83,true}
	};
	
	private DefaultTableModel tableModel = new DefaultTableModel(dataObjects,columNameStrings);
	
	private JTable jTable = new JTable(tableModel);
	
	private JButton jbtAddrow = new JButton("Add new row");
	private JButton jbtAddColum = new JButton("Add new column");
	private JButton jbtDeletRow = new JButton("Delet selected row");
	private JButton jbtDeleteColumn = new JButton("Delete selected column");
	private JButton jbtSave = new JButton("Save");
	private JButton jbtClear = new JButton("Clear");
	private JButton jbtRestore = new JButton("Restore");
	
	private JComboBox jcboSelectionMode = new JComboBox(new String[]{"SINGLE_SELECTION","SINGLE_INTERVAL_SELECTION",
		"MUTIPLE_INTERVAL_SELECTION"});
	
	private JCheckBox jchkRowSelectionAllowed = new JCheckBox("RowSelectionAllowed");
	private JCheckBox jchkColumnSelectionAllowed = new JCheckBox("ColumnSelectionAllowed");
	
	public ModifyTable(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		panel1.add(jbtAddrow);
		panel1.add(jbtAddColum);
		panel1.add(jbtDeletRow);
		panel1.add(jbtDeleteColumn);
		
		JPanel panel2 = new JPanel();
		panel2.add(jbtSave);
		panel2.add(jbtClear);
		panel2.add(jbtRestore);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout(5,0));
		panel3.add(new JLabel("Selection Mode"),BorderLayout.WEST);
		panel3.add(jcboSelectionMode,BorderLayout.CENTER);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.add(jchkRowSelectionAllowed);
		panel4.add(jchkColumnSelectionAllowed);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(2,1));
		panel5.add(panel3);
		panel5.add(panel4);
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BorderLayout());
		panel6.add(panel1,BorderLayout.SOUTH);
		panel6.add(panel2,BorderLayout.CENTER);
		
		add(panel5,BorderLayout.NORTH);
		add(new JScrollPane(jTable),BorderLayout.CENTER);
		add(panel6,BorderLayout.SOUTH);
		
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jbtAddrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jTable.getSelectedRow() >= 0)
					tableModel.insertRow(jTable.getSelectedRow(), new Vector());
				else
					tableModel.addRow(new Vector());
			}
		});
		
		jbtAddColum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = JOptionPane.showInputDialog("New Column Name");
				tableModel.addColumn(name,new Vector());
			}
		});
		
		jbtDeletRow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jTable.getSelectedRow() >= 0)
					tableModel.removeRow(jTable.getSelectedRow());
			}
		});
		
		jbtDeleteColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jTable.getSelectedColumn()>= 0){
					TableColumnModel columnModel = jTable.getColumnModel();
					TableColumn tableColumn = columnModel.getColumn(jTable.getSelectedColumn());
					columnModel.removeColumn(tableColumn);
				}
			}
		});
		
		jbtSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("table.dat"));
					out.writeObject(tableModel.getDataVector());
					out.writeObject(getColumnNames());
					out.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableModel.setRowCount(0);
			}
		});
		
		jbtRestore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("table.dat"));
					Vector rowData = (Vector)in.readObject();
					Vector columnNames = (Vector)in.readObject();
					tableModel.setDataVector(rowData, columnNames);
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		jchkRowSelectionAllowed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTable.setRowSelectionAllowed(jchkRowSelectionAllowed.isSelected());
				//jchkRowSelectionAllowed.isSelected();
			}
		});
		
		jchkColumnSelectionAllowed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTable.setColumnSelectionAllowed(jchkColumnSelectionAllowed.isSelected());
			}
		});
		
		jcboSelectionMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String selectedItem = (String)jcboSelectionMode.getSelectedItem();
				
				if(selectedItem.equals("SINGLE_SELECTION"))
					jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				else if(selectedItem.equals("SINGLE_INTERVAL_SELECTION"))
					jTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				else if(selectedItem.equals("MUTIPLE_INTERVAL_SELECTION"))
					jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			}
		});
	}
	private Vector getColumnNames(){
		Vector<String> columnName = new Vector<String>();
		
		for(int i = 0; i< jTable.getColumnCount(); i ++)
			columnName.add(jTable.getColumnName(i));
		return columnName;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ModifyTable();
		frame.pack();
		frame.setVisible(true);
	}

}
