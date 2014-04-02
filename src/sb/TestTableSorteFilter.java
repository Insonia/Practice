package sb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TestTableSorteFilter extends JFrame {
	private String[] columNameStrings = {"Country", "Capital", "Population","Democracy"};
	private Object[][] dataObjects = {
			{"USA","Washington,DC",280,true},
			{"Canda","Tttawa",32,true},
			{"Untied","Lodon",60,true},
			{"Germany","Berlin",83,true}
	};
	
	private JTable jTable = new JTable(dataObjects,columNameStrings);
	
	private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable.getModel());
	
	private JTextField jtfFilter = new JTextField();
	private JButton btFilter = new JButton("Filter");
	
	public TestTableSorteFilter(){
		jTable.setRowSorter(sorter);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("Spcifya word to match:"),BorderLayout.WEST);
		panel.add(jtfFilter,BorderLayout.CENTER);
		panel.add(btFilter,BorderLayout.EAST);
		
		add(panel,BorderLayout.SOUTH);
		add(new JScrollPane(jTable),BorderLayout.CENTER);
		
		btFilter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = jtfFilter.getText().trim();
				if(text.length() == 0)
					sorter.setRowFilter(null);
				else {
					sorter.setRowFilter(RowFilter.regexFilter(text + ".*"));
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestTableSorteFilter();
		frame.pack();
		frame.setVisible(true);
	}

}
