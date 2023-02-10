package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
	Cars cars;
	NumberGenerator numberGenerator;

	@BeforeEach
	void setup() {
		cars = new Cars();
		numberGenerator = new RandomNumberGenerator();
	}

	@DisplayName("자동차 이름 List로 Cars 등록 성공 테스트")
	@ParameterizedTest(name = "carNames = {0}, expectedSize = {1}")
	@MethodSource("carNamesDummy")
	void generateCarsSuccessTest(List<String> carNames, int expectedSize) {
		cars.createCars(carNames, numberGenerator);
		assertThat(cars.getCars()).hasSize(expectedSize);
	}

	@DisplayName("자동차 이름 갯수 0개거나 1개일 때 에러 발생 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesOneOrZeroDummy")
	void generateCarsOneOrZero(List<String> carNames) {
		assertThatThrownBy(() -> cars.createCars(carNames, numberGenerator))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 목록 중 중복 존재 시 에러 발생 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesDuplicatedDummy")
	void generateCarsDuplicate(List<String> carNames) {
		assertThatThrownBy(() -> cars.createCars(carNames, numberGenerator))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Cars 자동차 이동 정상 작동 테스트")
	@Test
	void moveCarsTest() {
		org.junit.jupiter.api.Assertions.assertDoesNotThrow(cars::moveCars);
	}

	@DisplayName("자동차 경기 우승자들 이름 조회 테스트")
	@ParameterizedTest(name = "winnerCarNames = {0}")
	@MethodSource("carNamesDummy")
	void findWinnerNamesTest(List<String> winnerCarNames) {
		cars.createCars(winnerCarNames, numberGenerator);
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
