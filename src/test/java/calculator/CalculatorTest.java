package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	void 덧셈(String input, int expected) {
		int result = Calculator.calculate(input);
		assertThat(result).isEqualTo(expected);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("1,2", 3),
				Arguments.of("1:5", 6),
				Arguments.of("1:5:7,5,1", 19),
				Arguments.of("//^\n1:5:7^5,1", 19));
	}
}
