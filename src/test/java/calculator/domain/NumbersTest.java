package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersTest {
	public static Stream<Arguments> createExpressionAndDelimiter() {
		return Stream.of(
			Arguments.of("-,3", ",|:", "Input has something not number"),
			Arguments.of("1,2,-3", ",|:", "Input has negative number")
		);
	}

	@Test
	void numbersTest() {
		//given
		String input = "1,2:3";
		String delimiter = ",|:";
		//then
		assertThat(new Numbers(input, delimiter).getNumbers()).isEqualTo(List.of(1, 2, 3));
	}

	@ParameterizedTest
	@MethodSource("createExpressionAndDelimiter")
	void validate(String expression, String delimiter, String errorMessage) {
		assertThatThrownBy(() -> {
			new Numbers(expression, delimiter);
		})
			.isInstanceOf(RuntimeException.class)
			.hasMessage(errorMessage);

	}
}