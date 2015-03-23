package ast;

public abstract class TreeNode {
	
	boolean negate = false;
	
	abstract double getVal();
	
	public double getValue(){
		
		return (!negate?1:-1)*getVal();
	}
	
	public void negate(){
		negate = !negate;
	}

}
