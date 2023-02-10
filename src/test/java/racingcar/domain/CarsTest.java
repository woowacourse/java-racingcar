package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.config.CarMovementConfig.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
	NumberGenerator numberGenerator;
	CarMovement carMovement;
	Cars cars;

	@BeforeEach

	void setup() {
		numberGenerator = new RandomNumberGenerator();
		carMovement = new CarMovement(numberGenerator);
		cars = new Cars();
	}

	@DisplayName("List<String> 타입의 자동차 이름들을 이용한 Cars 생성 성공 테스트")
	@ParameterizedTest(name = "carNames = {0}, expectedSize = {1}")
	@MethodSource("carNamesDummy")
	void generateCarsSuccessTest(List<String> carNames, int expectedSize) {
		cars.generateCars(carMovement, carNames);
		assertThat(cars.getCars()).hasSize(expectedSize);
	}

	@DisplayName("자동차 이름 갯수 0개 혹은 1개일 경우 예외 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesOneOrZeroDummy")
	void generateCarsOneOrZeroExceptionTest(List<String> carNames) {
		assertThatThrownBy(() -> cars.generateCars(carMovement, carNames))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 중복일 경우 예외 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesDuplicatedDummy")
	void generateCarsDuplicatedExceptionTest(List<String> carNames) {
		assertThatThrownBy(() -> cars.generateCars(carMovement, carNames))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Cars 자동차 전진 성공 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesDummy")
	void moveCarsSuccessTest(List<String> carNames) {
		carMovement = new CarMovement(MOVE_FORWARD_MIN_NUMBER::getNumber);
		cars.generateCars(carMovement, carNames);

		boolean isAllMoved = cars.moveCars();

		assertThat(isAllMoved).isTrue();
	}

	@DisplayName("Cars 자동차 전진 실패 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesDummy")
	void moveCarsFailTest(List<String> carNames) {
		carMovement = new CarMovement(STOP_MIN_NUMBER::getNumber);
		cars.generateCars(carMovement, carNames);

		boolean isAllMoved = cars.moveCars();

		assertThat(isAllMoved).isFalse();
	}

	@DisplayName("한 명 이상의 경기 우승자 이름 조회 성공 테스트")
	@ParameterizedTest(name = "winnerCarNames = {0}")
	@MethodSource("carNamesDummy")
	void findWinnerNamesSuccessTest(List<String> winnerCarNames) {
		cars.generateCars(carMovement, winnerCarNames);
		cars.moveCars();

		List<String> winnerNames = cars.findWinnerNames();

		assertThat(winnerNames).hasSizeGreaterThanOrEqualTo(1);
	}

	static Stream<Arguments> carNamesDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa", "bbbb", "cccc"), 3),
			Arguments.arguments(List.of("가나다라", "가나다라마", "가나다"), 3),
			Arguments.arguments(List.of("1234", "123", "12"), 3)
		);
	}

	static Stream<Arguments> carNamesOneOrZeroDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa"),
			Arguments.arguments(Collections.emptyList()))
		);
	}

	static Stream<Arguments> carNamesDuplicatedDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa", "aaaa")),
			Arguments.arguments(List.of("aaaa", "a", "aaaa"))
		);
	}
}