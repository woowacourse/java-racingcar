package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.car.Movement.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovement;
import racingcar.domain.car.Position;
import racingcar.domain.number.NumberGenerator;

@DisplayName("자동차 모음")
class CarsTest {
	NumberGenerator numberGenerator;
	CarMovement carMovement;
	Cars cars;

	@BeforeEach
	void setup() {
		carMovement = new CarMovement(numberGenerator);
		cars = new Cars();
	}

	@DisplayName("더미 데이터 저장 성공 테스트")
	@ParameterizedTest(name = "carDummy = {0}, expectedSize = {1}")
	@MethodSource("carsDummy")
	void generateCarsSuccessTest(List<Car> carDummy, int expectedSize) {
		cars.addCars(carDummy);
		assertThat(cars.getCars()).hasSize(expectedSize);
	}

	@DisplayName("개수 0개 혹은 1개일 경우 예외 테스트")
	@ParameterizedTest
	@MethodSource("carOneOrZeroDummy")
	void generateCarsOneOrZeroExceptionTest(List<Car> carDummy) {
		assertThatThrownBy(() -> cars.addCars(carDummy))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이름 중복일 경우 예외 테스트")
	@ParameterizedTest(name = "carDummy = {0}")
	@MethodSource("carNamesDuplicatedDummy")
	void generateCarsDuplicatedExceptionTest(List<Car> carDummy) {
		assertThatThrownBy(() -> cars.addCars(carDummy))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("전진 성공 테스트")
	@ParameterizedTest
	@MethodSource("moveCarsSuccessDummy")
	void moveCarsSuccessTest(List<Car> carDummy, int moveForwardNumber) {
		cars.addCars(carDummy);
		carMovement = new CarMovement(() -> moveForwardNumber);

		cars.moveCars(carMovement);
		boolean isCarsMovedForward = cars.getCars()
			.stream()
			.allMatch(car -> car.isSamePosition(new Position(MOVE_FORWARD.getDistance())));

		assertThat(isCarsMovedForward).isTrue();
	}

	@DisplayName("전진 실패 테스트")
	@ParameterizedTest
	@MethodSource("carsDummy")
	void moveCarsFailTest(List<Car> carDummy, int moveStopNumber) {
		cars.addCars(carDummy);
		carMovement = new CarMovement(() -> moveStopNumber);

		cars.moveCars(carMovement);
		boolean isCarsMovedForward = cars.getCars()
			.stream()
			.allMatch(car -> car.isSamePosition(new Position(MOVE_STOP.getDistance())));

		assertThat(isCarsMovedForward).isTrue();
	}

	@DisplayName("한 명 이상의 경기 우승자 이름 조회 성공 테스트")
	@ParameterizedTest
	@MethodSource("carsDummy")
	void findWinnerNamesSuccessTest(List<Car> carDummy, int moveNumber) {
		cars.addCars(carDummy);
		carMovement = new CarMovement(() -> moveNumber);
		carMovement.move();

		final List<String> carDummyNames = carDummy.stream()
			.map(Car::getNameValue)
			.collect(Collectors.toList());
		final List<String> winnerNames = cars.findWinnerNames();

		assertThat(carDummyNames).containsAll(winnerNames);
	}

	static Stream<Arguments> carsDummy() {
		return Stream.of(
			Arguments.arguments(List.of(
					CarGenerator.from("aaaa"),
					CarGenerator.from("bbbb"),
					CarGenerator.from("cccc")),
				3),
			Arguments.arguments(List.of(
					CarGenerator.from("가나다라"),
					CarGenerator.from("가나다라마"),
					CarGenerator.from("가나다")),
				3),
			Arguments.arguments(List.of(
					CarGenerator.from("1234"),
					CarGenerator.from("123"),
					CarGenerator.from("12")),
				3)
		);
	}

	static Stream<Arguments> moveCarsSuccessDummy() {
		return Stream.of(
			Arguments.arguments(List.of(
					CarGenerator.from("aaaa"),
					CarGenerator.from("bbbb"),
					CarGenerator.from("cccc")),
				4),
			Arguments.arguments(List.of(
					CarGenerator.from("가나다라"),
					CarGenerator.from("가나다라마"),
					CarGenerator.from("가나다")),
				4),
			Arguments.arguments(List.of(
					CarGenerator.from("1234"),
					CarGenerator.from("123"),
					CarGenerator.from("12")),
				4)
		);
	}

	static Stream<Arguments> carOneOrZeroDummy() {
		return Stream.of(
			Arguments.arguments(List.of(CarGenerator.from("aaaa")),
				Arguments.arguments(Collections.emptyList()))
		);
	}

	static Stream<Arguments> carNamesDuplicatedDummy() {
		return Stream.of(
			Arguments.arguments(List.of(
				CarGenerator.from("aaaa"),
				CarGenerator.from("aaaa"))),
			Arguments.arguments(List.of(
				CarGenerator.from("aaaa"),
				CarGenerator.from("a"),
				CarGenerator.from("aaaa")))
		);
	}
}