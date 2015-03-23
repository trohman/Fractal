package ast;

public abstract class UnaryOperationNode extends OperationNode{

	TreeNode operand;
	
	public void setOperand(TreeNode operand){
		this.operand = operand;
	}
	
}
