package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.Car;
import racinggame.Cars;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {
	List<Car> cars;

	@BeforeEach
	void setup() {
		cars = new ArrayList<Car>();

		cars.add(new Car("bmo", 1));
		cars.add(new Car("pobi", 2));
		cars.add(new Car("crong", 4));
		cars.add(new Car("honux", 6));
	}

	@Test
	void maxPosition() {
		assertThat(new Cars(cars).getMaxPosition()).isEqualTo(6);
	}

	@Test
	void 생성() {
		List<Car> comparingCars = new ArrayList<Car>();
		Car car = new Car("bmo", 0);
		car.move(true);
		comparingCars.add(car);
		comparingCars.add(new Car("pobi", 2));
		comparingCars.add(new Car("crong", 4));
		comparingCars.add(new Car("honux", 6));

		assertThat(new Cars(cars)).isEqualTo(new Cars(comparingCars));
	}

	@AfterEach
	void tearDown() {
		cars = null;
	}
}
