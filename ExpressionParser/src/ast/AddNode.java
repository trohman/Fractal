package ast;

public class AddNode extends BinaryOperationNode{

	@Override
	double evaluate() {
		return lOperand.getValue() + rOperand.getValue();
	}

}
