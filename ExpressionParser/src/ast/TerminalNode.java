package ast;

public abstract class TerminalNode extends TreeNode {
	
	double numVal;
	
	public void setValue(double d){
		numVal = d;
	}
}
