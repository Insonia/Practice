package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TestModelDemo extends JFrame {
	public TestModelDemo(){
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
		
		root = new DefaultMutableTreeNode("WOrld");
		root.add(europe);
		root.add(northAmeric);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(new JScrollPane(new JTree(root)));
		panel.add(new JScrollPane(new JTree(new DefaultTreeModel(root))));
		
		JTextArea jtaMessage = new JTextArea();
		jtaMessage.setWrapStyleWord(true);
		jtaMessage.setLineWrap(true);
		add(new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel, new JScrollPane(jtaMessage)),BorderLayout.CENTER);
		
		jtaMessage.append("Depth of the node US is " + us.getDepth());
		jtaMessage.append("\nLevel of the node us is " + us.getLevel());
		jtaMessage.append("\nFirst child of the root is " + root.getFirstChild());
		jtaMessage.append("\nFirst leaf of the root is " + root.getFirstLeaf());
		jtaMessage.append("\nNumber of the children of the root is " + root.getChildCount());
		jtaMessage.append("\nNumber of leaves in the tree is " + root.getLeafCount());
		String breadthFirstSearchResult = "";
		
		Enumeration bf = root.breadthFirstEnumeration();
		while (bf.hasMoreElements()) {
			//Object object = (//Object) bf.nextElement();
			breadthFirstSearchResult += bf.nextElement().toString() + " ";
		}
		jtaMessage.append("\nBreadth-first traversal from the root is " + breadthFirstSearchResult);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestModelDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
