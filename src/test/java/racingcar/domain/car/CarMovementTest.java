package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.car.Movement.*;
import static racingcar.dummy.TestDataDummy.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.number.NumberGenerator;

@DisplayName("자동차 움직임")
class CarMovementTest {
	@DisplayName("자동차 움직임 생성 성공 테스트")
	@Test
	void createCarMovementSuccessTest() {
		assertDoesNotThrow(() -> new CarMovement(MOVE_FORWARD_NUMBER_GENERATOR));
	}

	@DisplayName("자동차 움직임 성공 테스트")
	@ParameterizedTest(name = "number = {0}, expectedMovement = {1}")
	@MethodSource("moveDummy")
	void isRandomCarMoveTest(NumberGenerator numberGenerator, Movement expectedMovement) {
		CarMovement carMovement = new CarMovement(numberGenerator);

		final Movement movement = carMovement.move();

		assertThat(movement).isEqualTo(expectedMovement);
	}

	static Stream<Arguments> moveDummy() {
		return Stream.of(
			Arguments.arguments(MOVE_STOP_NUMBER_GENERATOR, MOVE_STOP),
			Arguments.arguments(MOVE_FORWARD_NUMBER_GENERATOR, MOVE_FORWARD)
		);
	}
}