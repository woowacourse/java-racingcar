package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;
import static racingcar.dummy.TestDataDummy.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.CarMovement;
import racingcar.domain.car.Position;

@DisplayName("게임 매니저")
class GameManagerTest {
	GameManager gameManager;

	@DisplayName("생성 성공 테스트")
	@Test
	void createSuccessTest() {
		Assertions.assertDoesNotThrow(() -> {
			CarMovement carMovement = new CarMovement(MOVE_FORWARD_NUMBER_GENERATOR);
			Cars cars = new Cars();
			return new GameManager(carMovement, cars);
		});
	}

	@DisplayName("자동차 전체 움직임 성공 테스트")
	@ParameterizedTest
	@MethodSource("moveCarsSuccessDummy")
	void moveCarsSuccessTest(CarMovement carMovement, Position movedPosition) {
		Cars cars = new Cars();
		gameManager = new GameManager(carMovement, cars);
		gameManager.setUpCars(CAR_NAMES);
		gameManager.setUpGameRound(TOTAL_ROUND);

		boolean isCarMovedCorrectly = gameManager.moveCars()
			.getCars()
			.stream()
			.allMatch(position -> position.isSamePosition(movedPosition));

		assertThat(isCarMovedCorrectly).isTrue();
	}

	@DisplayName("라운드 설정 후 라운드 진행 확인 성공 테스트")
	@Test
	void setRoundAndCheckSuccessTest() {
		Cars cars = new Cars();
		gameManager = new GameManager(CAR_MOVEMENT_FORWARD, cars);
		gameManager.setUpCars(CAR_NAMES);
		gameManager.setUpGameRound(TOTAL_ROUND);

		boolean isGameContinue = gameManager.isGameContinue();
		assertThat(isGameContinue).isTrue();
	}

	static Stream<Arguments> moveCarsSuccessDummy() {
		return Stream.of(
			Arguments.arguments(CAR_MOVEMENT_STOP, MOVE_ZERO_POSITION),
			Arguments.arguments(CAR_MOVEMENT_FORWARD, MOVE_FORWARD_ONCE_POSITION)
		);
	}
}