package stringcalculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("빈 문자열 입력 시 예외 발생")
	@Test
	void inputEmptyString() {
		assertThatThrownBy(() -> stringCalculator.sum(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("빈 문자열을 입력할 수 없습니다.");
	}

	@DisplayName("쉼표, 콜론 구분자로 분리")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3"})
	void splitString(String input) {
		assertThat(stringCalculator.split(input)).containsExactly("1","2","3");
	}

	@DisplayName("구분된 문자열이 숫자인지 확인")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "a,false"})
	void isNumber(String text, Boolean expected) {
		assertThat(stringCalculator.isNumber(text)).isEqualTo(expected);
	}

	@DisplayName("구분된 문자열을 숫자로 변환 - 성공")
	@ParameterizedTest
	@CsvSource(value = {"1,1", "2,2", "3,3"})
	void successToNumber(String text, int expected) {
		assertThat(stringCalculator.toNumber(text)).isEqualTo(expected);
	}

	@DisplayName("구분된 문자열을 숫자로 변환 - 실패")
	@ParameterizedTest
	@ValueSource(strings = {"a", "b", "c"})
	void failToNumber(String text) {
		assertThatThrownBy(() -> stringCalculator.toNumber(text))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자를 입력 하셔야합니다.");
	}

	@DisplayName("입력된 숫자가 양수인지 확인")
	@ParameterizedTest
	@CsvSource(value = {"-2,true", "-1,true", "0,false", "1,false", "2,false"})
	void isNegative(int number, boolean expected) {
		assertThat(stringCalculator.isNegative(number)).isEqualTo(expected);
	}
}
