package domain;

import static domain.CarFactory.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static final String CARS_NAME = "benz,audi,honda";

	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars(arrangeCars(CARS_NAME));
	}

	@Test
	@DisplayName("모든 자동차들이 전진 조건에 만족하면 전진합니다")
	public void moveCars() {
		cars.moveCars(() -> true);
		for (Car car : cars.getCars()) {
			assertEquals(car.getPosition(), 1);
		}
	}

	@Test
	@DisplayName("모든 자동차들이 전진 조건에 만족하지 않으면 정지합니다")
	public void stopCars() {
		cars.moveCars(() -> false);
		for (Car car : cars.getCars()) {
			assertEquals(car.getPosition(), 0);
		}
	}
}
