package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.Car;
import racinggame.Cars;
import racinggame.Winners;

public class WinnersTest {
	Winners winners;
	List<Car> cars;

	@BeforeEach
	void setup() {
		cars = new ArrayList<Car>();
		cars.add(new Car("lsp", 1));
		cars.add(new Car("bmo", 0));
		cars.add(new Car("jake", 0));
		cars.add(new Car("finn", 0));
		winners = new Winners(new Cars(cars));
	}

	@Test
	void 우승자() {
		List<Car> comparingCars = new ArrayList<Car>();
		comparingCars.add(new Car("lsp", 1));
		comparingCars.add(new Car("amo", 0));
		Winners comparingWinners = new Winners(new Cars(comparingCars));

		assertThat(winners).isEqualTo(comparingWinners);

		cars.add(new Car("finn", 2));
		comparingCars.add(new Car("finn", 2));

		winners = new Winners(new Cars(cars));
		comparingWinners = new Winners(new Cars(comparingCars));

		assertThat(winners).isEqualTo(comparingWinners);
	}

	@AfterEach
	void tearDown() {
		cars = null;
		winners = null;
	}
}
