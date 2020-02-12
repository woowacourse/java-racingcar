package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void constructor() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1))
			.withMessage("자동차의 위치는 0 이상이어야 합니다.");
	}
}
