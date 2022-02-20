package racingcar.validator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.validator.TryRoundNumberValidator.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.vo.TryRoundNumber;

class TryRoundNumberValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	@DisplayName("시행횟수에 정상적인 입력의 경우 예외가 발생하지 않는다")
	public void normalInput(String input) {
		Assertions.assertDoesNotThrow(() -> new TryRoundNumber(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {",", "#", "@"})
	@DisplayName("시행횟수에 특수문자 입력시 예외 발생한다")
	public void exceptionInputSpecialCharacter(String input) {
		assertThatThrownBy(
			() -> new TryRoundNumber(input)
		).hasMessage(INVALID_NOT_NUMBER);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	@DisplayName("시행횟수에 양수가 아닌 경우 예외 발생한다")
	public void exceptionInputNotPositiveNumber(String input) {
		assertThatThrownBy(
			() -> new TryRoundNumber(input)
		).hasMessage(INVALID_NOT_POSITIVE_NUMBER);
	}
}
