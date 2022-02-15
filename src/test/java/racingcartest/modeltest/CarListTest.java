package racingcartest.modeltest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.CarList;

public class CarListTest {
	CarList carList;

	@DisplayName("차가 0대인 경우")
	@Test
	public void carListTest_zero() {
		assertThrows(IllegalArgumentException.class, () -> {
			carList = new CarList(new ArrayList<>());
		});
	}

	@DisplayName("이름 중복 테스트")
	@Test
	public void carListTest_duplicateName() {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("car"));
		cars.add(new Car("car"));

		assertThrows(IllegalArgumentException.class, () -> {
			carList = new CarList(cars);
		});
	}

}
