package table;

public class Operation {
	public static enum op  {SHIFT, REDUCE, GOTO, ACCEPT};
	
	op operation;
	int state;
	
	public Operation(op oper, int s){
		operation = oper;
		state = s;
	}

	public op getOperation() {
		return operation;
	}

	public int getState() {
		return state;
	}

}
