package ast;

public class CosNode extends UnaryOperationNode {

	@Override
	double evaluate() {
		return Math.cos(operand.getValue());
	}

}
