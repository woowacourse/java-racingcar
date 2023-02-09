package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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
		CarRepository.add(new Car("code"));
	}

	@Nested
	class CarsMovementTest {
		@Test
		@DisplayName("모든 차의 위치가 이동해야 한다.")
		void moveAllCarsTest() {
			carService = new CarService(nineGenerator);
			carService.moveCars();

			String expected = "woowa : --\ntech : --\ncode : --";
			assertThat(CarRepository.getPositionToString()).isEqualTo(expected);
		}

		@Test
		@DisplayName("모든 차의 위치가 변하지 않아야 한다.")
		void moveNoneCarsTest() {
			carService = new CarService(zeroGenerator);
			carService.moveCars();

			String expected = "woowa : -\ntech : -\ncode : -";
			assertThat(CarRepository.getPositionToString()).isEqualTo(expected);
		}
	}
}
