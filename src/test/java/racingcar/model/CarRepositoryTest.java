package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {
	private CarRepository carRepository;

	@BeforeEach
	void setUp() {
		carRepository = new CarRepository();
	}

	@Test
	void 저장() {
		Car car = new Car("범고래");
		carRepository.save(car);
		assertThat(carRepository.getCars().size()).isEqualTo(1);
	}

	@Test
	void Car_3개_저장() {
		Car car1 = new Car("범고래");
		Car car2 = new Car("소주캉");
		Car car3 = new Car("범고래2");
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);

		assertThat(carRepository.getCars().size()).isEqualTo(3);
	}

	@Test
	void 게임_진행() {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4));
		Car car1 = new Car("범고래");
		Car car2 = new Car("소주캉");
		carRepository.save(car1);
		carRepository.save(car2);

		carRepository.move(numbers);
		List<CarDto> winners = carRepository.getCars();
		CarDto expected = new CarDto("소주캉", 1);
		CarDto expected2 = new CarDto("범고래", 0);
		assertThat(winners.contains(expected)).isTrue();
		assertThat(winners.contains(expected2)).isTrue();
	}

	@Test
	void 우승자() {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4));
		Car car1 = new Car("범고래");
		Car car2 = new Car("소주캉");
		carRepository.save(car1);
		carRepository.save(car2);

		carRepository.move(numbers);
		List<CarDto> winners = carRepository.getWinners();
		CarDto expected = new CarDto("소주캉", 1);
		assertThat(winners.contains(expected)).isTrue();
	}
}
