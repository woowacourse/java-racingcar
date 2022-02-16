package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.vo.TryRoundNumber.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryRoundNumberTest {

	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	@DisplayName("정상적인 입력")
	public void normalInput(String input) {
		Assertions.assertDoesNotThrow(() -> new TryRoundNumber(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {",", "#", "@"})
	@DisplayName("특수문자 입력시 예외 발생")
	public void exceptionInputSpecialCharacter(String input) {
		assertThatThrownBy(
			() -> new TryRoundNumber(input)
		).hasMessage(INVALID_NOT_NUMBER);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	@DisplayName("양수가 아닌 경우 예외 발생")
	public void exceptionInputNotPositiveNumber(String input) {
		assertThatThrownBy(
			() -> new TryRoundNumber(input)
		).hasMessage(INVALID_NOT_POSITIVE_NUMBER);
	}


}