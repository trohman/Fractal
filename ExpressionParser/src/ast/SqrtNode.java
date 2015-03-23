package ast;

public class SqrtNode extends UnaryOperationNode{

	@Override
	double evaluate() {
		return Math.sqrt(operand.getValue());
	}

}
