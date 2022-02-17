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
	@DisplayName("자동차 이름 정상 입력 후 저장")
	public void saveCar() {
		carRepository.addCar(Car.from("does"));

		int carCount = carRepository.count();

		assertThat(carCount).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 이름 중복시 예외")
	public void duplicateCarName() {
		carRepository.addCar(Car.from("does"));

		assertThatThrownBy(() -> carRepository.addCar(Car.from("does")))
			.isInstanceOf(IllegalStateException.class);
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
