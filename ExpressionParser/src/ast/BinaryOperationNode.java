package ast;

public abstract class BinaryOperationNode extends OperationNode{
	
	protected TreeNode lOperand;
	protected TreeNode rOperand;
	
	public void setLeftOperand(TreeNode lOperand){
		this.lOperand = lOperand;
	}
	
	public void setRightOperand(TreeNode rOperand){
		this.rOperand = rOperand;
	}
}
