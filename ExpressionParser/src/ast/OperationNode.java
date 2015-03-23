package ast;

public abstract class OperationNode extends TreeNode{
	
	abstract double evaluate();
	
	 double getVal(){
		return evaluate();
	}

}
