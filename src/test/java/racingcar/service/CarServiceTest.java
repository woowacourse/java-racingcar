package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

class CarServiceTest {

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
	CarService carService;

	@BeforeEach
	void tearDown() {
		CarRepository.clear();
		CarRepository.add(new Car("woowa"));
		CarRepository.add(new Car("tech"));
	}
	@Test
	@DisplayName("Repository에 저장된 차들의 위치를 문자열로 반환해야 한다.")
	void getPositionToStringTest() {
		carService = new CarService(zeroGenerator);

		String expected = "woowa : -\ntech : -";
		assertThat(carService.getPositionToString()).isEqualTo(expected);
	}

	@Nested
	class CarsMovementTest {
		@Test
		@DisplayName("모든 차의 위치가 이동해야 한다.")
		void moveAllCarsTest() {
			CarRepository.add(new Car("code"));
			carService = new CarService(nineGenerator);
			carService.moveCars();

			String expected = "woowa : --\ntech : --\ncode : --";
			assertThat(carService.getPositionToString()).isEqualTo(expected);
		}

		@Test
		@DisplayName("모든 차의 위치가 변하지 않아야 한다.")
		void moveNoneCarsTest() {
			CarRepository.add(new Car("code"));
			carService = new CarService(zeroGenerator);
			carService.moveCars();

			String expected = "woowa : -\ntech : -\ncode : -";
			assertThat(carService.getPositionToString()).isEqualTo(expected);
		}
	}

	@Nested
	class WinnerTest {
		@Test
		@DisplayName("가장 많이 전진한 자동차가 우승자여야 한다.")
		void getWinnersTest() {
			assertThat(CarRepository.getCars().size()).isEqualTo(2);
			carService = new CarService(nineGenerator);
			carService.moveCars();

			CarRepository.add(new Car("code"));
			Assertions.assertThat(carService.getWinners()).containsExactly("woowa", "tech");
		}
	}
}
