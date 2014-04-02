package sb;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestTable extends JFrame {
	private String[] columNameStrings = {"Country", "Capital", "Population","Democracy"};
	private Object[][] dataObjects = {
			{"USA","Washington,DC",280,true},
			{"Canda","Tttawa",32,true},
			{"Untied","Lodon",60,true},
			{"Germany","Berlin",83,true}
	};
	
	private JTable jTable = new JTable(dataObjects,columNameStrings);
	public TestTable(){
		add(new JScrollPane(jTable));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestTable();
		frame.pack();
		frame.setVisible(true);
	}

}
