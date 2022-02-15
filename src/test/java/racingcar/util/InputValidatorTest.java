package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.InputValidator;

public class InputValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {""})
	public void 자동차_이름_빈문자열_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.checkCarNames(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcde,dfsd", "abcm"})
	public void 자동차_이름_정상_입력(String name) {
		InputValidator.checkCarNames(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	public void 시도횟수_정상(String input) {
		InputValidator.checkAttemptNumber(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {""})
	public void 시도횟수_빈문자열_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.checkAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수가 입력되지 않았습니다.");
	}
}
