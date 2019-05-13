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

		cars.add(new Car("bmo", 0));
		cars.add(new Car("pobi", 2));
		cars.add(new Car("crong", 4));
		cars.add(new Car("honux", 6));
	}

	@Test
	void maxPosition() {
		assertThat(new Cars(cars).getMaxPosition()).isEqualTo(6);
	}

	@Test
	void size() {
		assertThat(new Cars(cars).size()).isEqualTo(4);
	}

	@AfterEach
	void tearDown() {
		cars = null;
	}
}
