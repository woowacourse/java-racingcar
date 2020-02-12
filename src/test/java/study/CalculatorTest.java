package study;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	@Test
	public void add() {
		int result = Calculator.calculate("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@ParameterizedTest
	@MethodSource("generateInput")
	public void customAdd(String input, int expected) {
		int result = Calculator.calculate(input);
		assertThat(result).isEqualTo(expected);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(
			Arguments.of("//;\n1;2;3", 6),
			Arguments.of("//#\n2#3#4", 9),
			Arguments.of("//-\n2-3-4", 9),
			Arguments.of("//*\n4*5*6", 15));
	}

	@ParameterizedTest
	@MethodSource("wrongInput")
	public void wrongInputTest(String input) {
		assertThatThrownBy(() -> Calculator.calculate(input))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("잘못 입력");
	}

	static Stream<Arguments> wrongInput() {
		return Stream.of(
			Arguments.of("-1,2:3"),
			Arguments.of("1,2,dmkf"),
			Arguments.of("-1,-2,dmkf"),
			Arguments.of("dsads,qqq,z"));
	}
}
