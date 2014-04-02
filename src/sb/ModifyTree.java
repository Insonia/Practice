package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class ModifyTree extends JFrame {
	private JComboBox jcboSelectionMode = new JComboBox(new String[]{"CONTIGUOUS_TREE_SELECTION","DISCONTIGUOUS_TREE_SELECTION",
			"SINGLE_TREE_SELECTION"});
	
	private JCheckBox jchkEditable = new JCheckBox();
	
	private JButton jbtAdd = new JButton("Add a Child for Selected Node");
	private JButton jbtRemove = new JButton("Remove seleced Nodes");
	
	private JTree jTree1, jTree2;
	
	public ModifyTree(){
		DefaultMutableTreeNode root, europe, northAmeric, us;
		europe = new DefaultMutableTreeNode("Europe");
		europe.add(new DefaultMutableTreeNode("UK"));
		europe.add(new DefaultMutableTreeNode("Germany"));
		europe.add(new DefaultMutableTreeNode("Francy"));
		europe.add(new DefaultMutableTreeNode("Norway"));
		
		northAmeric = new DefaultMutableTreeNode("northAmerica");
		us = new DefaultMutableTreeNode("US");
		us.add(new DefaultMutableTreeNode("California"));
		us.add(new DefaultMutableTreeNode("NewYork"));
		us.add(new DefaultMutableTreeNode("Texas"));
		us.add(new DefaultMutableTreeNode("Florida"));
		us.add(new DefaultMutableTreeNode("Illinois"));
		northAmeric.add(us);
		northAmeric.add(new DefaultMutableTreeNode("Canada"));
		
		root = new DefaultMutableTreeNode("World");
		root.add(europe);
		root.add(northAmeric);
		
		jcboSelectionMode.setSelectedIndex(1);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("SelectionMode"));
		p1.add(jcboSelectionMode);
		p1.add(new JLabel("editable"));
		p1.add(jchkEditable);
		
		JPanel p2 = new JPanel(new GridLayout(1,2));
		p2.add(new JScrollPane(jTree1 = new JTree(root)));
		p2.add(new JScrollPane(jTree2 = new JTree(new DefaultTreeModel(root))));
		
		JPanel p3 = new JPanel();
		p3.add(jbtAdd);
		p3.add(jbtRemove);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		
		jcboSelectionMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jcboSelectionMode.getSelectedItem().equals("CONTIGUOUS_TREE_SELECTION"))
					jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
				else if(jcboSelectionMode.getSelectedItem().equals("DISCONTIGUOUS_TREE_SELECTION"))
					jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				else if(jcboSelectionMode.getSelectedItem().equals("SINGLE_TREE_SELECTION"))
					jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			}
		});
		
		jchkEditable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTree1.setEditable(jchkEditable.isSelected());
			}
		});
		
		jbtAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode parent = (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
				
				if(parent == null){
					JOptionPane.showMessageDialog(null, "No NOde in the left tree is selected");
					return;
				}
				
				String nodeName = JOptionPane.showInputDialog(null, "Enter a Child node for " + parent, "Add a Child", 
						JOptionPane.QUESTION_MESSAGE);
				
				parent.add(new DefaultMutableTreeNode(nodeName));
				
				((DefaultTreeModel)(jTree1.getModel())).reload();
				((DefaultTreeModel)(jTree2.getModel())).reload();
			}
		});
		
		jbtRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TreePath[] paths = jTree1.getSelectionPaths();
				
				if(paths == null)
				{
					JOptionPane.showMessageDialog(null, "No Node in the left tree is selected");
					return;
				}
				
				for(int i = 0 ;i < paths.length; i++){
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)(paths[i].getLastPathComponent());
					if(node.isRoot()){
						JOptionPane.showMessageDialog(null, "Cannot remove the root");
					}
					else
						node.removeFromParent();
					
					((DefaultTreeModel)(jTree1.getModel())).reload();
					((DefaultTreeModel)(jTree2.getModel())).reload();
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ModifyTree();
		frame.pack();
		frame.setVisible(true);
	}

}
