package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	@DisplayName("포지션이 음수로 생성될 때 예외 발생 테스트")
	void testNegative() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1))
				.withMessage("자동차의 위치는 0 이상이어야 합니다.");
	}

	@Test
	void match() {
		Position actual = new Position(1);
		Position expected = new Position(1);
		assertThat(actual.match(expected)).isTrue();
	}

	@Test
	void move() {
		Position position = new Position(0);;
		Position expected = new Position(1);
		position.move();
		assertThat(position.match(expected)).isTrue();
	}
}
