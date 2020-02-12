package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputViewTest {
	@Test
	public void splitAsCommaTest() {
		String value = "A,B,C";
		List<String> result = InputView.splitAsComma(value);

		assertThat(result).contains("A");
		assertThat(result).contains("B");
		assertThat(result).contains("C");
	}

	@ParameterizedTest
	@MethodSource("generateInput")
	public void checkLengthTest(List<String> input, boolean expected) {
		assertThat(InputView.checkLength(input)).isEqualTo(expected);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(
			Arguments.of(Arrays.asList("ABCDEF", "B", "C"), false),
			Arguments.of(Arrays.asList("A", "B", "ABCDEF"), false),
			Arguments.of(Arrays.asList("A", "B", ""), false),
			Arguments.of(Arrays.asList(""), false),
			Arguments.of(Arrays.asList("A", "B", "C"), true));
	}
}
