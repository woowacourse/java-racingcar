package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Movement;

class WinnersTest {
	@DisplayName("한 명 이상의 경기 우승자 이름 조회 성공 테스트")
	@Test
	void findWinnerNamesSuccessTest() {
		final Car carOne = Car.from("헤나");
		final Car carTwo = Car.from("소니");
		carOne.move(Movement.MOVE_FORWARD);
		carTwo.move(Movement.MOVE_STOP);

		final List<Car> cars = List.of(carOne, carTwo);
		final Winners winners = new Winners(cars);
		final List<String> winnerNames = winners.getWinnerNames();

		assertThat(winnerNames).containsExactly(carOne.getNameValue());
	}
}