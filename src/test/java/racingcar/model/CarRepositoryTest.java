package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {
	CarRepository carRepository;
	@BeforeEach
	void setUp() {
		carRepository = CarRepository.getInstance();
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
		Car car2= new Car("소주캉");
		Car car3 = new Car("범고래2");
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);

		assertThat(carRepository.getCars().size()).isEqualTo(3);
	}

	@Test
	void 우승자() {
		Car car1 = new Car("범고래");
		Car car2= new Car("소주캉");
		Car car3 = new Car("범고래2");
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);

		for (int i = 0; i < 3; i++) {
			carRepository.move();
		}
	}

	@AfterEach
	void afterEach() {
		carRepository.clear();
	}
}
