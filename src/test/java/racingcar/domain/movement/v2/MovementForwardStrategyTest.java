package racingcar.domain.movement.v2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직임 전진 전략")
class MovementForwardStrategyTest {
	@DisplayName("이동 거리 확인 성공 테스트")
	@Test
	void move() {
		int distance = new MovementForwardStrategy().getDistance();
		assertThat(distance).isOne();
	}
}