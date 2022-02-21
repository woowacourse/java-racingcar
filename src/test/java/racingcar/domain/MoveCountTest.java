package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.domain.MoveCount.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveCountTest {
	@ParameterizedTest
	@ValueSource(ints = {-1, 0})
	@DisplayName("입력값이 양수가 아닐 경우")
	void notPositive(int moveCount) {
		assertThatThrownBy(() -> new MoveCount(moveCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_NOT_POSITIVE);
	}
}
