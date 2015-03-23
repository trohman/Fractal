package ast;

public class LogNode extends UnaryOperationNode{

	@Override
	double evaluate() {
		return Math.log(operand.getValue());
	}

}
