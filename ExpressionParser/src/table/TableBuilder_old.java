package table;

import java.util.Stack;

import parser.Nonterminals;
import parser.Terminals;
import table.Operation.op;

public class TableBuilder_old {
	
	Operation shiftTable[][];
	Operation gotoTable[][];
	Rule rules[];
	
	public TableBuilder_old(){
		
		//buildRules();
		buildShiftTable();
		buildGOTOTable();
	}
	
	public Operation[][] getShiftTable() {
		return shiftTable;
	}

	public Operation[][] getGotoTable() {
		return gotoTable;
	}

	public Rule[] getRules() {
		return rules;
	}

	// table[state][terminal]
	private void buildShiftTable(){
		int terminals = 16;
		shiftTable = new Operation[39][terminals];	//15 terminals
		
		shiftTable[0][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[0][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[0][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[0][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[0][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[0][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[0][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[0][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[0][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[0][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[1][i] = new Operation(op.REDUCE, 20);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[2][i] = new Operation(op.REDUCE, 19);
		}
		
		shiftTable[3][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[3][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[3][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[3][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[3][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[3][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[3][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[3][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[3][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[3][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		shiftTable[4][Terminals.var.ordinal()] = new Operation(op.SHIFT, 19);
		shiftTable[4][Terminals.number.ordinal()] = new Operation(op.SHIFT, 20);
		
		shiftTable[5][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[5][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[5][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[5][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[6][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[6][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[6][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[6][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[7][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[7][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[7][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[7][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[8][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[8][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[8][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[8][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[9][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[9][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[9][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[9][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[10][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[10][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[10][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[10][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		
		shiftTable[11][Terminals.EOF.ordinal()] = new Operation(op.ACCEPT, 4);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[12][i] = new Operation(op.REDUCE, 1);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[13][i] = new Operation(op.REDUCE, 2);
		}
		shiftTable[13][Terminals.plus.ordinal()] = new Operation(op.SHIFT, 28);
		shiftTable[13][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 29);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[14][i] = new Operation(op.REDUCE, 3);
		}
		shiftTable[14][Terminals.star.ordinal()] = new Operation(op.SHIFT, 28);
		shiftTable[14][Terminals.divide.ordinal()] = new Operation(op.SHIFT, 31);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[15][i] = new Operation(op.REDUCE, 6);
		}
		shiftTable[15][Terminals.power.ordinal()] = new Operation(op.SHIFT, 32);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[16][i] = new Operation(op.REDUCE, 9);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[17][i] = new Operation(op.REDUCE, 11);
		}
		
		shiftTable[18][Terminals.rparen.ordinal()] = new Operation(op.SHIFT, 33);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[19][i] = new Operation(op.REDUCE, 21);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[20][i] = new Operation(op.REDUCE, 18);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[21][i] = new Operation(op.REDUCE, 12);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[22][i] = new Operation(op.REDUCE, 13);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[23][i] = new Operation(op.REDUCE, 15);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[24][i] = new Operation(op.REDUCE, 14);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[25][i] = new Operation(op.REDUCE, 16);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[26][i] = new Operation(op.REDUCE, 17);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[27][i] = new Operation(op.ACCEPT, 0);
		}
		
		shiftTable[28][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[28][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[28][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[28][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[28][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[28][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[28][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[28][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[28][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[28][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		shiftTable[29][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[29][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[29][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[29][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[29][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[29][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[29][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[29][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[29][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[29][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		shiftTable[30][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[30][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[30][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[30][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[30][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[30][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[30][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[30][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[30][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[30][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		shiftTable[31][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[31][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[31][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[31][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[31][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[31][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[31][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[31][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[31][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[31][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		shiftTable[32][Terminals.var.ordinal()] = new Operation(op.SHIFT, 1);
		shiftTable[32][Terminals.number.ordinal()] = new Operation(op.SHIFT, 2);
		shiftTable[32][Terminals.lparen.ordinal()] = new Operation(op.SHIFT, 3);
		shiftTable[32][Terminals.minus.ordinal()] = new Operation(op.SHIFT, 4);
		shiftTable[32][Terminals.sin.ordinal()] = new Operation(op.SHIFT, 5);
		shiftTable[32][Terminals.cos.ordinal()] = new Operation(op.SHIFT, 6);
		shiftTable[32][Terminals.tan.ordinal()] = new Operation(op.SHIFT, 7);
		shiftTable[32][Terminals.abs.ordinal()] = new Operation(op.SHIFT, 8);
		shiftTable[32][Terminals.log.ordinal()] = new Operation(op.SHIFT, 9);
		shiftTable[32][Terminals.sqrt.ordinal()] = new Operation(op.SHIFT, 10);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[33][i] = new Operation(op.REDUCE, 22);
		}
		
		for(int i = 0; i < terminals; i++){
			shiftTable[34][i] = new Operation(op.REDUCE, 4);
		}
		shiftTable[34][Terminals.star.ordinal()] = new Operation(op.SHIFT, 30);
		shiftTable[34][Terminals.divide.ordinal()] = new Operation(op.SHIFT, 31);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[35][i] = new Operation(op.REDUCE, 5);
		}
		shiftTable[35][Terminals.star.ordinal()] = new Operation(op.SHIFT, 30);
		shiftTable[35][Terminals.divide.ordinal()] = new Operation(op.SHIFT, 31);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[36][i] = new Operation(op.REDUCE, 7);
		}
		shiftTable[36][Terminals.power.ordinal()] = new Operation(op.SHIFT, 32);
		
		for(int i = 0; i < terminals; i++){
			shiftTable[37][i] = new Operation(op.REDUCE, 8);
		}
		shiftTable[37][Terminals.power.ordinal()] = new Operation(op.SHIFT, 32);

		for(int i = 0; i < terminals; i++){
			shiftTable[38][i] = new Operation(op.REDUCE, 10);
		}
	}
	
	private void buildGOTOTable(){
		gotoTable = new Operation[38][6];
		
		gotoTable[0][Nonterminals.expression.ordinal()] = new Operation(op.GOTO, 12);
		gotoTable[0][Nonterminals.add.ordinal()] = new Operation(op.GOTO, 13);
		gotoTable[0][Nonterminals.multiply.ordinal()] = new Operation(op.GOTO, 14);
		gotoTable[0][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 15);
		gotoTable[0][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[0][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[3][Nonterminals.expression.ordinal()] = new Operation(op.GOTO, 18);
		gotoTable[3][Nonterminals.add.ordinal()] = new Operation(op.GOTO, 13);
		gotoTable[3][Nonterminals.multiply.ordinal()] = new Operation(op.GOTO, 14);
		gotoTable[3][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 15);
		gotoTable[3][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[3][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[5][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 21);
		
		gotoTable[6][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 22);
		
		gotoTable[7][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 23);
		
		gotoTable[8][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 24);
		
		gotoTable[9][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 25);		
		
		gotoTable[10][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 26);
		
		gotoTable[28][Nonterminals.multiply.ordinal()] = new Operation(op.GOTO, 34);
		gotoTable[28][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 15);
		gotoTable[28][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[28][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[29][Nonterminals.multiply.ordinal()] = new Operation(op.GOTO, 35);
		gotoTable[29][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 15);
		gotoTable[29][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[29][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[30][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 36);
		gotoTable[30][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[30][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[31][Nonterminals.power.ordinal()] = new Operation(op.GOTO, 37);
		gotoTable[31][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 16);
		gotoTable[31][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
		
		gotoTable[32][Nonterminals.unary.ordinal()] = new Operation(op.GOTO, 38);
		gotoTable[32][Nonterminals.atom.ordinal()] = new Operation(op.GOTO, 17);
	}
	/*
	private void buildRules(){
		rules = new Rule[23];
		rules[1] = new Rule(Nonterminals.expression, 1){

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
			
		};
		
		rules[2] = new Rule(Nonterminals.expression, 1){

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				return arg1;
			}
			
		};
			
		rules[3] = new Rule(Nonterminals.add, 1){

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
			
		}
		;
		rules[4] = new Rule(Nonterminals.add, 3){

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op1 = Double.parseDouble(arg1);
				double op2 = Double.parseDouble(arg3);
				System.out.println(arg1 + "+" + arg3);
				return ""+ (op1 + op2);
			}
			
		};
		rules[5] = new Rule(Nonterminals.add, 3){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op1 = Double.parseDouble(arg1);
				double op2 = Double.parseDouble(arg3);
				return ""+ (op1 - op2);
			}
		};
		rules[6] = new Rule(Nonterminals.multiply, 1){
		

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
		};
		rules[7] = new Rule(Nonterminals.multiply, 3){
		
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op1 = Double.parseDouble(arg1);
				double op2 = Double.parseDouble(arg3);
				return ""+ (op1 * op2);
			}
		};
		rules[8] = new Rule(Nonterminals.multiply, 3){
			

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op1 = Double.parseDouble(arg1);
				double op2 = Double.parseDouble(arg3);
				return ""+ (op1 / op2);
			}
		};
		rules[9] = new Rule(Nonterminals.power, 1){
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
		};
		rules[10] = new Rule(Nonterminals.power, 3){
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op1 = Double.parseDouble(arg1);
				double op2 = Double.parseDouble(arg3);
				return ""+ Math.pow(op1 , op2);
			}
		};
		rules[11] = new Rule(Nonterminals.unary, 1){
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
		};
		rules[12] = new Rule(Nonterminals.unary, 2){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.sin(op2);
			}
		};
		rules[13] = new Rule(Nonterminals.unary, 2){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.cos(op2);
			}
		};
		rules[14] = new Rule(Nonterminals.unary, 2){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.tan(op2);
			}
		};
		rules[15] = new Rule(Nonterminals.unary, 2){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.abs(op2);
			}
		};
		rules[16] = new Rule(Nonterminals.unary, 2){
			

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.log(op2);
			}
		};
		rules[17] = new Rule(Nonterminals.unary, 2){
			

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ Math.sqrt(op2);
			}
		};
		rules[18] = new Rule(Nonterminals.atom, 2){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				double op2 = Double.parseDouble(arg2);
				return ""+ (-op2);
			}
		};
		rules[19] = new Rule(Nonterminals.atom, 1){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg1;
			}
		};
		rules[20] = new Rule(Nonterminals.atom, 1){
			
			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		rules[21] = new Rule(Nonterminals.atom, 2){
			

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		rules[22] = new Rule(Nonterminals.atom, 3){
			

			@Override
			public String performSemanticAction(String arg1, String arg2,
					String arg3) {
				// TODO Auto-generated method stub
				return arg2;
			}
		};
	}
*/
}
