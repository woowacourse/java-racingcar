package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.movement.v1.Movement.*;
import static racingcar.dummy.TestDataDummy.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.movement.v1.Movement;
import racingcar.domain.number.NumberGenerator;

@DisplayName("자동차 움직임")
class CarMovementTest {
	@DisplayName("자동차 움직임 생성 성공 테스트")
	@Test
	void createCarMovementSuccessTest() {
		assertDoesNotThrow(() -> new CarMovement(MOVE_FORWARD_NUMBER_GENERATOR));
	}

	@DisplayName("자동차 움직임 버전 V1 성공 테스트")
	@ParameterizedTest(name = "number = {0}, expectedMovement = {1}")
	@MethodSource("moveV1Dummy")
	void isRandomCarMoveV1Test(NumberGenerator numberGenerator, Movement expectedMovement) {
		CarMovement carMovement = new CarMovement(numberGenerator);

		final Movement movement = carMovement.moveV1();

		assertThat(movement).isEqualTo(expectedMovement);
	}

	@DisplayName("자동차 움직임 버전 V2 성공 테스트")
	@ParameterizedTest(name = "number = {0}, expectedMovement = {1}")
	@MethodSource("moveV2Dummy")
	void isRandomCarMoveV2Test(NumberGenerator numberGenerator, int expectedDistance) {
		CarMovement carMovement = new CarMovement(numberGenerator);

		final int moveDistance = carMovement.moveV2();

		assertThat(moveDistance).isEqualTo(expectedDistance);
	}

	static Stream<Arguments> moveV1Dummy() {
		return Stream.of(
			Arguments.arguments(MOVE_STOP_NUMBER_GENERATOR, MOVE_STOP),
			Arguments.arguments(MOVE_FORWARD_NUMBER_GENERATOR, MOVE_FORWARD)
		);
	}

	static Stream<Arguments> moveV2Dummy() {
		return Stream.of(
			Arguments.arguments(MOVE_STOP_NUMBER_GENERATOR, 0),
			Arguments.arguments(MOVE_FORWARD_NUMBER_GENERATOR, 1)
		);
	}
}