package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {
	CarRepository cars;
	@BeforeEach
	void setUp() {
		cars = CarRepository.getInstance();
	}

	@Test
	void 저장() {
		Car car = new Car("범고래");
		cars.save(car);
		assertThat(cars.size()).isEqualTo(1);
	}

	@Test
	void Car_3개_저장() {
		Car car1 = new Car("범고래");
		Car car2= new Car("소주캉");
		Car car3 = new Car("범고래2");
		cars.save(car1);
		cars.save(car2);
		cars.save(car3);

		assertThat(cars.size()).isEqualTo(3);
	}

	@AfterEach
	void afterEach() {
		CarRepository repository = CarRepository.getInstance();
		repository.clear();
	}
}
