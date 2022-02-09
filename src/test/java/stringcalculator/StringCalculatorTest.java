package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@DisplayName("빈 문자열 입력 시 예외 발생")
	@Test
	void inputEmptyString() {
		StringCalculator stringCalculator = new StringCalculator();
		Assertions.assertThatThrownBy(() -> stringCalculator.sum(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("빈 문자열을 입력할 수 없습니다.");
	}
}
