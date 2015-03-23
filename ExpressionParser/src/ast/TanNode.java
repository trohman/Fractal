package ast;

public class TanNode extends UnaryOperationNode{

	@Override
	double evaluate() {
		return Math.sqrt(operand.getValue());
	}

}
