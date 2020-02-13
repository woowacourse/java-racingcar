package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 수식 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class Expression {
	private final List<Operand> operands;

	public Expression(final List<Operand> operands) {
		this.operands = operands;
	}

	public static Expression valueOf(List<Integer> numbers) {
		return new Expression(numbers.stream()
				.map(Operand::new)
				.collect(Collectors.toList()));
	}

	public Operand calculate() {
		if (operands == null || operands.isEmpty()) {
			return new Operand(0);
		}
		return operands.stream()
				.reduce(new Operand(0), Operand::sum);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Expression that = (Expression)o;
		return Objects.equals(operands, that.operands);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operands);
	}
}
