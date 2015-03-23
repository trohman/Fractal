package ast;

public class MultiplicationNode extends BinaryOperationNode{
	@Override
	double evaluate() {
		return lOperand.getValue() * rOperand.getValue();
	}
}
