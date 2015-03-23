package parser;

import java.util.Stack;


import table.*;
import table.Operation.op;
import ast.*;

public class Parser {
	
	
	Operation shiftTable[][];
	Operation gotoTable[][];
	Rule rules[];
	Token nextToken;
	Stack<Integer> state;
	Stack<TreeNode> semantic;
	Lexer lex;
	
	
	public AbstractsSyntaxTree parseExpression(String s){
		lex = new Lexer();
		lex.setInputString(s);
		state = new Stack<Integer>();
		state.push(0);
		
		semantic = new Stack<TreeNode>();
		semantic.push(null);
		
		TableBuilder tab = new TableBuilder();
		shiftTable = tab.getShiftTable();
		gotoTable = tab.getGotoTable();
		rules= tab.getRules();
		
		nextToken = lex.nextToken();
		while(handleToken());
		System.out.println("DONE");
		
		AbstractsSyntaxTree tree = new AbstractsSyntaxTree();
		tree.setRoot(semantic.pop());
		return tree;
	}
	
	public static void main(String args[]){
		Parser p = new Parser();
		AbstractsSyntaxTree tree = p.parseExpression("3*4+(2+4*(3+4))");
		System.out.println(tree.evaluateTree());
	
	}
	
	public boolean handleToken(){
		int curState = state.peek();
		Operation nextOp = shiftTable[curState][nextToken.getType().ordinal()];
		//System.out.println("STATE: " + curState + " : " + nextToken.getValue());
		//System.out.println(nextToken.getValue() + ": "+ nextOp.getOperation()+ ":" + nextOp.getState());
		if(nextOp.getOperation() == op.ACCEPT){
			return false;
		}else if(nextOp.getOperation() == op.SHIFT){
			
			state.push(nextOp.getState());
			TerminalNode n = null;
			if(nextToken.getType() == Terminals.number){
				n = new NumberNode();
				n.setValue(Double.parseDouble(nextToken.getValue()));
			}
			semantic.push(n);
			nextToken=lex.nextToken();
		}else if(nextOp.getOperation() == op.REDUCE){
			Rule rule = rules[nextOp.getState()];
			if(nextOp.getState() == 2 && nextToken.getType() == Terminals.EOF){
				return false;
			}
			TreeNode args[] = new TreeNode[3];
			for(int i = 0; i < rule.getArgs(); i++){
				state.pop();
				args[rule.getArgs() - i -1] = semantic.pop();
			}
			TreeNode result = rule.performSemanticAction(args[0], args[1], args[2]);
			int myState = state.peek();
			nextOp = gotoTable[myState][rule.getProduces().ordinal()];
			//System.out.println(nextToken.getValue() + ": "+ nextOp.getOperation()+ ":" + nextOp.getState());
			state.push(nextOp.getState());
			semantic.push(result);
			
		}
		return true;
	}


}
