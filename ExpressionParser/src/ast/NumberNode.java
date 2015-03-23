package ast;

public class NumberNode extends TerminalNode{

	@Override
	double getVal() {
		return numVal;
	}

}
