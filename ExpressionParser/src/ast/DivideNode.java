package ast;

public class DivideNode extends BinaryOperationNode {
	@Override
	double evaluate() {
		return lOperand.getValue() / rOperand.getValue();
	}
}
