package ast;

public class PowerNode extends BinaryOperationNode {
	@Override
	double evaluate() {
		return Math.pow(lOperand.getValue(), rOperand.getValue());
	}
}
