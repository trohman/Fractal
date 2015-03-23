package ast;

public class AbsNode extends UnaryOperationNode {

	@Override
	double evaluate() {
		// TODO Auto-generated method stub
		return Math.abs(operand.getVal());
	}

}
