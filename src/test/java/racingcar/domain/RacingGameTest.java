package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.utils.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

class RacingGameTest {
	class ZeroGenerator implements NumberGenerator {
		@Override
		public int getNumber() {
			return 0;
		}
	}

	class NineGenerator implements NumberGenerator {
		@Override
		public int getNumber() {
			return 9;
		}
	}

	ZeroGenerator zeroGenerator = new ZeroGenerator();
	NineGenerator nineGenerator = new NineGenerator();
	RacingGame racingGame;

	@BeforeEach
	void tearDown() {
		RacingCars.clear();
		RacingCars.add(new Car("woowa"));
		RacingCars.add(new Car("tech"));
	}

	@Nested
	class CarsMovementTest {
		@Test
		@DisplayName("모든 차의 위치가 이동해야 한다.")
		void moveAllCarsTest() {
			RacingCars.add(new Car("code"));
			racingGame = new RacingGame(nineGenerator);
			racingGame.moveCars();

			List<Car> cars = RacingCars.getCars();
			List<Integer> carsPosition = cars.stream()
					.map(Car::getPosition)
					.collect(Collectors.toList());
			assertThat(carsPosition).containsExactly(1, 1, 1);
		}

		@Test
		@DisplayName("모든 차의 위치가 변하지 않아야 한다.")
		void moveNoneCarsTest() {
			RacingCars.add(new Car("code"));
			racingGame = new RacingGame(zeroGenerator);
			racingGame.moveCars();

			List<Car> cars = RacingCars.getCars();
			List<Integer> carsPosition = cars.stream()
					.map(Car::getPosition)
					.collect(Collectors.toList());
			assertThat(carsPosition).containsExactly(0, 0, 0);
		}
	}

	@Nested
	class WinnerTest {
		@Test
		@DisplayName("가장 많이 전진한 자동차가 우승자여야 한다.")
		void getWinnersTest() {
			assertThat(RacingCars.getCars().size()).isEqualTo(2);
			racingGame = new RacingGame(nineGenerator);
			racingGame.moveCars();

			RacingCars.add(new Car("code"));
			assertThat(racingGame.getWinners()).containsExactly("woowa", "tech");
		}
	}
}
