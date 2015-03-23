package ast;

public class AbstractsSyntaxTree {
	
	TreeNode root;
	
	public void setRoot(TreeNode tree){
		root = tree;
	}
	
	 public double evaluateTree(){
		return root.getValue();
	}

}
