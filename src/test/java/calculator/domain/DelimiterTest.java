package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DelimiterTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2:3!,|:"}, delimiter = '!')
	void defineDelimiter(String input, String delimiter) {
		assertThat(new Delimiter(input).getDelimiter()).isEqualTo(delimiter);
	}

	@Test
	void customDelimiter() {
		String input = "//a\n1a2a3";
		String delimiter = "a";
		assertThat(new Delimiter(input).getDelimiter()).isEqualTo(delimiter);
	}

	@Test
	void hasCustomDelimiterTest() {
		//given
		String input = "//,\n";
		//then
		assertThat(new Delimiter(input).hasCustomDelimiter(input)).isTrue();
	}

	// class CarRacingTest {
	// 	@ParameterizedTest
	// 	@ValueSource(ints = {-1, 0})
	// 	void validatePositiveNumber(int negativeNumber) {
	// 		assertThatThrownBy(() -> {
	// 			CarRacing.validatePositiveNumber(negativeNumber);
	// 		}).isInstanceOf(IllegalArgumentException.class)
	// 			.hasMessage("2이상의 수를 입력해야합니다.");
	// 	}
	// }
}