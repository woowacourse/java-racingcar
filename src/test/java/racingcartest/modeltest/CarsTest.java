package racingcartest.modeltest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {
	Cars cars;

	@DisplayName("차가 0대인 경우")
	@Test
	public void carsTest_zero() {
		assertThrows(IllegalArgumentException.class, () -> {
			cars = new Cars(new ArrayList<>());
		});
	}

	@DisplayName("이름 중복 테스트")
	@Test
	public void carsTest_duplicateName() {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("car"));
		cars.add(new Car("car"));

		assertThrows(IllegalArgumentException.class, () -> {
			this.cars = new Cars(cars);
		});
	}

}
