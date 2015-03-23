package table;

import java.util.Stack;

import ast.TreeNode;
import parser.Nonterminals;

public abstract class Rule implements semantics {
	
	Nonterminals produces;
	int args;
	
	public Rule(Nonterminals product, int args){
		produces = product;
		this.args = args;
	}

	public Nonterminals getProduces() {
		return produces;
	}

	public int getArgs() {
		return args;
	}
}

 abstract interface semantics{
	public abstract TreeNode performSemanticAction(TreeNode arg1, TreeNode arg2, TreeNode arg3);
}
