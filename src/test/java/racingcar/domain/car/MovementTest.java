package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.car.Movement.from;
import static racingcar.domain.car.Movement.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("움직임")
class MovementTest {
	@DisplayName("0 이상 3 이하 MOVE_STOP 반환 성공 테스트")
	@ParameterizedTest(name = "number = {0}")
	@ValueSource(ints = {0, 1, 2, 3})
	void moveStopNumberRangeSuccessTest(int number) {
		Movement movement = from(number);
		assertThat(movement).isEqualTo(MOVE_STOP);
	}

	@DisplayName("4 이상 9 이하 MOVE_FORWARD 반환 성공 테스트")
	@ParameterizedTest(name = "number = {0}")
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveForwardNumberRangeSuccessTest(int number) {
		Movement movement = from(number);
		assertThat(movement).isEqualTo(MOVE_FORWARD);
	}

	@DisplayName("0 미만, 9 초과 조회시 예외 발생 테스트")
	@ParameterizedTest(name = "wrongNumber = {0}")
	@ValueSource(ints = {-10, -5, -1, 10, 11, 20})
	void movementWrongNumberRangeExceptionTest(int number) {
		assertThatThrownBy(() -> Movement.from(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("MOVE_STOP 거리 0 반환 성공 테스트")
	@Test
	void moveStopDistanceSuccessTest() {
		assertThat(MOVE_STOP.getDistance()).isZero();
	}

	@DisplayName("MOVE_FORWARD 거리 1 반환 성공 테스트")
	@Test
	void moveForwardDistanceSuccessTest() {
		assertThat(MOVE_FORWARD.getDistance()).isEqualTo(1);
	}
}