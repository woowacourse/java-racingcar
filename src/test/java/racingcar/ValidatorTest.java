package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.Validator;

public class ValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"아라", "abc"})
	@DisplayName("시도횧수 타입 예외")
	public void generateExceptionWithAttemptNumber(String input) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofIntegerInput(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}


	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	@DisplayName("시도 횟수 정상")
	public void passAttemptTypeInput(String input) {
		Validator.ofIntegerInput(input);
	}
}
