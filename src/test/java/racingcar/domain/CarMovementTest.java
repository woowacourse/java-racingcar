package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.config.CarMovementConfig.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarMovementTest {
	CarMovement carMovement;
	NumberGenerator numberGenerator;

	@DisplayName("자동차 움직임 생성 테스트")
	@Test
	void createCarMovementTest() {
		assertDoesNotThrow(() -> new CarMovement(numberGenerator));
	}

	@DisplayName("자동차 움직임 확인 테스트")
	@ParameterizedTest(name = "number = {0}, isMoveForward = {1}")
	@MethodSource("moveDummy")
	void isRandomCarMoveTest(int number, boolean expected) {
		numberGenerator = new RandomNumberGenerator();
		carMovement = new CarMovement(() -> number);

		boolean isCarMoveForward = carMovement.isMove();

		assertThat(isCarMoveForward).isEqualTo(expected);
	}

	static Stream<Arguments> moveDummy() {
		return Stream.of(
			Arguments.arguments(MOVE_FORWARD_MIN_NUMBER.getNumber(), true),
			Arguments.arguments(MOVE_FORWARD_MAX_NUMBER.getNumber(), true),
			Arguments.arguments((MOVE_FORWARD_MIN_NUMBER.getNumber() + MOVE_FORWARD_MAX_NUMBER.getNumber()) / 2, true),
			Arguments.arguments(STOP_MIN_NUMBER.getNumber(), false),
			Arguments.arguments(STOP_MAX_NUMBER.getNumber(), false),
			Arguments.arguments((STOP_MIN_NUMBER.getNumber() + STOP_MAX_NUMBER.getNumber()) / 2, false)
		);
	}
}