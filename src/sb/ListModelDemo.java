package sb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListModelDemo extends JFrame{
	private DefaultListModel listModel = new DefaultListModel();
	private JList jlst = new JList(listModel);
	private JButton jbtAdd = new JButton("Add Item");
	private JButton jbtRemove = new JButton("Remove Item");
	
	public ListModelDemo(){
		listModel.addElement("Item1");
		listModel.addElement("Item2");
		listModel.addElement("Item3");
		listModel.addElement("Item4");
		listModel.addElement("Item5");
		listModel.addElement("Item6");
		listModel.addElement("Item7");
		listModel.addElement("Item8");
		
		JPanel panel = new JPanel();
		panel.add(jbtAdd);
		panel.add(jbtRemove);
		
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(jlst),BorderLayout.CENTER);
		
		jbtAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newItem = JOptionPane.showInputDialog("Enter a new item");
				
				if( newItem != null)
					if(jlst.getSelectedIndex() == -1)
						listModel.addElement(newItem);
					else
						listModel.add(jlst.getSelectedIndex(), newItem);
			}
		});
		
		jbtRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.remove(jlst.getSelectedIndex());
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ListModelDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
