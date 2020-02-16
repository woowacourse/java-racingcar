package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcargame.exception.InvalidTryNumberException;

@SuppressWarnings("NonAsciiCharacters")
class TryNumberTest {

	@ParameterizedTest
	@ValueSource(strings = {"1번", "두 번", "3.5"})
	void 정수가_아닌_값_입력(String input) {
		assertThatThrownBy(() ->
			new TryNumber(input))
			.isInstanceOf(NumberFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	void 최소시도회수_1보다_작은_값_입력(String input) {
		assertThatThrownBy(() ->
			new TryNumber(input))
			.isInstanceOf(InvalidTryNumberException.class);
	}
}