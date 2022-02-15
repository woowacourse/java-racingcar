package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarRepositoryTest {

	private final CarRepository carRepository = CarRepository.getInstance();

	@AfterEach
	void clearRepository() {
		carRepository.clear();
	}

	@Test
	@DisplayName("position 가장 큰 자동차 찾기 테스트")
	void findMaxPositionCarsTest() throws Exception {
		carRepository.addCar(Car.of("a", 1));
		carRepository.addCar(Car.of("b", 2));
		carRepository.addCar(Car.of("c", 2));

		List<Car> cars = carRepository.findMaxPositionCars();

		assertThat(cars.size()).isEqualTo(2);

		cars.stream()
			.forEach(car -> {
				assertThat(car.isSamePosition(2)).isTrue();
			});
	}
}
