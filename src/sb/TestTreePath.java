package sb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TestTreePath extends JFrame {
	private JTree jTree = new JTree();
	private JButton jbtShowPath = new JButton("ShowPath");
	private JButton jbtShowPaths = new JButton("ShowPaths");
	private JTextArea jta = new JTextArea();
	
	public TestTreePath(){
		JSplitPane jsPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(jTree), new JScrollPane(jta));
		
		JPanel panel = new JPanel();
		panel.add(jbtShowPath);
		panel.add(jbtShowPaths);
		
		add(panel,BorderLayout.NORTH);
		add(jsPane,BorderLayout.CENTER);
		
		jbtShowPath.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TreePath path = jTree.getSelectionPath();
				jta.append("\nProcessing a single path\n");
				jta.append("# of elemens: " + path.getPathCount());
				jta.append("\nLast element: " + path.getLastPathComponent());
				jta.append("\nFrom last node in tht path to the root: ");
				TreeNode node = (TreeNode)path.getLastPathComponent();
				while(node != null){
					jta.append(node.toString() + " ");
					node = node.getParent();
				}
			}
		});
		
		jbtShowPaths.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta.append("\nProcessing multiple paths\n");
				TreePath[] paths = jTree.getSelectionPaths();
				for(int i = 0; i < paths.length; i ++)
					jta.append(paths[i].toString() + "\n");
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TestTreePath();
		frame.pack();
		frame.setVisible(true);
	}

}
