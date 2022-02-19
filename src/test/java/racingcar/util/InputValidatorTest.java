package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.validator.InputValidator;

public class InputValidatorTest {

	@DisplayName("자동차 이름 정상 입력")
	@ParameterizedTest
	@ValueSource(strings = {"abcde,dfsd", "abcm"})
	public void correctCarNameTest(String name) {
		InputValidator.checkCarNames(name);
	}

	@DisplayName("자동차 이름 빈문자열 예외")
	@ParameterizedTest
	@ValueSource(strings = {""})
	public void emptyCarNameErrorTest(String name) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.checkCarNames(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
	}

	@DisplayName("시도횟수 정상")
	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	public void correctAttemptNumberTest(String input) {
		InputValidator.checkAttemptNumber(input);
	}

	@DisplayName("시도횟수 빈문자열 예외")
	@ParameterizedTest
	@ValueSource(strings = {""})
	public void emptyAttemptNumberErrorTest(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.checkAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수가 입력되지 않았습니다.");
	}
}
