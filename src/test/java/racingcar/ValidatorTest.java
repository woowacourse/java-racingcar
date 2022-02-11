package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.Validator;

public class ValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"아라", "abc"})
	public void 시도횟수_타입_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofIntegerInput(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}


	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	public void 시도횟수_정상(String input) {
		Validator.ofIntegerInput(input);
	}
}
