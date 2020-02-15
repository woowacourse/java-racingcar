package calculator.domain;

import static calculator.domain.StringSplitter.*;

import java.util.List;

public class Calculator {
	public Operand run(String inputExpression) {
		List<Operand> operands = splitString(inputExpression);
		Expression expression = new Expression(operands);
		return expression.calculate();
	}
}
