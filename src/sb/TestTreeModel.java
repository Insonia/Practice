package sb;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;

public class TestTreeModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTree jTree = new JTree();
		TreeModel model = jTree.getModel();
		traversal(model, model.getRoot());
	}
	
	private static void traversal(TreeModel model, Object root){
		System.out.println(root + " ");
		if(model.isLeaf(root)) return;
		for(int i = 0; i < model.getChildCount(root); i++)
			traversal(model, model.getChild(root, i));
	}

}
