package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.InputValidator;

public class InputValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {""})
	public void 자동차_이름_빈문자열_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.ofCarNamesInput(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcde,dfsd", "abcm,er"})
	public void 자동차_이름_정상_입력(String name) {
		InputValidator.ofCarNamesInput(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"아라", "abc"})
	public void 시도횟수_타입_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.ofAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void 시도횟수_범위_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.ofAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
	}


	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	public void 시도횟수_정상(String input) {
		InputValidator.ofAttemptNumber(input);
	}
}
