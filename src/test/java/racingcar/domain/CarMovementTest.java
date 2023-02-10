package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.config.CarMovementConfig.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarMovementTest {
	NumberGenerator numberGenerator;
	CarMovement carMovement;

	@DisplayName("자동차 이동 기능 생성 성공 테스트")
	@Test
	void createRandomCarMovementTest() {
		carMovement = new CarMovement(() -> 0);
		carMovement.isCarMoveForward();
		assertThat(carMovement).isNotNull();
	}

	@DisplayName("자동차 이동 테스트")
	@ParameterizedTest(name = "number = {0}, isMoveForward = {1}")
	@MethodSource("moveForwardDummy")
	void isRandomCarMoveForwardTest(int number, boolean expected) {
		numberGenerator = new RandomNumberGenerator();
		carMovement = new CarMovement(() -> number);
		boolean isCarMoveForward = carMovement.isCarMoveForward();
		assertThat(isCarMoveForward).isEqualTo(expected);
	}

	static Stream<Arguments> moveForwardDummy() {
		return Stream.of(
			Arguments.arguments(MOVE_FORWARD_MIN_NUMBER.getNumber(), true),
			Arguments.arguments(MOVE_FORWARD_MAX_NUMBER.getNumber(), true),
			Arguments.arguments((MOVE_FORWARD_MIN_NUMBER.getNumber()+MOVE_FORWARD_MAX_NUMBER.getNumber())/2, true),
			Arguments.arguments(STOP_MIN_NUMBER.getNumber(), false),
			Arguments.arguments(STOP_MAX_NUMBER.getNumber(), false),
			Arguments.arguments((STOP_MIN_NUMBER.getNumber()+STOP_MAX_NUMBER.getNumber())/2, false)
		);
	}
}
