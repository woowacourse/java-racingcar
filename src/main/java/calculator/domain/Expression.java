package calculator.domain;

import java.util.List;

public class Expression {
	private List<Operand> operands;

	public Expression(List<Operand> operands) {
		this.operands = operands;
	}

	public Operand calculate() {
		if (operands == null || operands.isEmpty()) {
			return Operand.ZERO;
		}
		return operands.stream()
			.reduce(Operand.ZERO, Operand::sum);
	}
}
