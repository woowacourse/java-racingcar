package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racing.view.InputView;

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
	@MethodSource("generateInputCarNames")
	public void checkLengthTest(List<String> input, boolean expected) {
		assertThat(InputView.checkLength(input)).isEqualTo(expected);
	}

	static Stream<Arguments> generateInputCarNames() {
		return Stream.of(
			Arguments.of(Arrays.asList("ABCDEF", "B", "C"), false),
			Arguments.of(Arrays.asList("A", "B", "ABCDEF"), false),
			Arguments.of(Arrays.asList("A", "B", ""), false),
			Arguments.of(Arrays.asList(""), false),
			Arguments.of(Arrays.asList("A", "B", "C"), true));
	}

	@Test
	@DisplayName("리스트가 비지 않았는지 확인하는 테스트")
	public void checkNotEmptyTest() {
		assertThat(InputView.checkNotEmpty(Arrays.asList("5"))).isEqualTo(true);
		assertThat(InputView.checkNotEmpty(Collections.EMPTY_LIST)).isEqualTo(false);
	}

	@ParameterizedTest
	@MethodSource("generateInputString")
	public void checkNotNullTest(String input, boolean expected) {
		assertThat(InputView.checkNotNull(input)).isEqualTo(expected);
	}

	static Stream<Arguments> generateInputString() {
		return Stream.of(
			Arguments.of(null, false),
			Arguments.of("AB,C,D,EF,G", true));
	}

	@Test
	public void checkRoundNumberTest() {
		assertThat(InputView.checkNumber("5")).isTrue();
		assertThat(InputView.checkNumber("-")).isFalse();
		assertThat(InputView.checkNumber("5.")).isFalse();
	}
}
