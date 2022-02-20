package racingcar.models;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.RacingGameMessage;

class CarRepositoryTest {

	final CarRepository carRepository = new CarRepository("a, b, c", RacingGameMessage.CAR_NAME_DISTRIBUTOR);

	@Test
	@DisplayName("승자 리스트가 정상적으로 가져와 지는지 확인한다.")
	void testGetWinnersName() {
		assertThat(carRepository.getWinnersName().size()).isGreaterThan(0);
	}

	@Test
	@DisplayName("한 턴을 실행했을 때 자동차들이 앞으로 전진 또는 제자리인지 확인")
	void testGoForward() {
		carRepository.getThisTurnResult()
			.forEach((car) -> {
				assertThat(car.getPosition()).isLessThanOrEqualTo(1);
			});
	}

	@BeforeEach
	void startThisTurn() {
		carRepository.startThisTurn();
	}
}