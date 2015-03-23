package ast;

public class SubtractNode extends BinaryOperationNode{
	@Override
	double evaluate() {
		return lOperand.getValue() - rOperand.getValue();
	}
}
