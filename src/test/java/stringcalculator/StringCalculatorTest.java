package stringcalculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}
