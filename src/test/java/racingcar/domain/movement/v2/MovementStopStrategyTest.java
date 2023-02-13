package racingcar.domain.movement.v2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직임 정지 전략")
class MovementStopStrategyTest {
	@DisplayName("이동 거리 확인 성공 테스트")
	@Test
	void move() {
		int distance = new MovementStopStrategy().getDistance();
		assertThat(distance).isZero();
	}

}