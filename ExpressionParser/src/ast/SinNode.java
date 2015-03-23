package ast;

public class SinNode extends UnaryOperationNode{

	@Override
	double evaluate() {
		return Math.sin(operand.getValue());
	}

}
