package racingcar.models;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.RacingGameMessage;

class CarRepositoryTest {

	final CarRepository carRepository = new CarRepository("a,b,c", RacingGameMessage.CAR_NAME_DISTRIBUTOR);

	@Test
	@DisplayName("승자 리스트가 정상적으로 가져와 지는지 확인한다.")
	void testGetWinnersName() {
		final List<String> expected = Arrays.asList("b", "c");

		assertThat(carRepository.getWinnersName()).usingRecursiveComparison()
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("한 턴을 실행했을 때 자동차들이 앞으로 전진 또는 제자리인지 확인")
	void testGoForward() {
		final List<Integer> actual = carRepository.getThisTurnResult()
			.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList());
		final List<Integer> expected = Arrays.asList(0, 1, 1);

		assertThat(actual).usingRecursiveComparison()
			.isEqualTo(expected);
	}

	@BeforeEach
	void startThisTurn() {
		carRepository.startThisTurn(Arrays.asList(1, 5, 6));
	}
}