package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void constructor() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1))
				.withMessage("자동차의 위치는 0 이상이어야 합니다.");
	}

	@Test
	void move() {
		final Position position = new Position(0);
		position.move();
		final Position expected = new Position(1);
		assertThat(position).isEqualTo(expected);
	}
}
