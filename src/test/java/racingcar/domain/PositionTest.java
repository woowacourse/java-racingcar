package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.domain.Position.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	@DisplayName("자동차 위치가 음수인 경우")
	void notPositive() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_NEGATIVE);
	}
}
