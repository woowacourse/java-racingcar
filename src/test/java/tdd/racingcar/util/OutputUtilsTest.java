package tdd.racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.Power;

class OutputUtilsTest {
	private Cars cars;
	private List<Car> values;

	@BeforeEach
	void init() {
		values = new ArrayList<>();
		final Car car = new Car("a");
		final Car car1 = new Car("b");
		final Car car2 = new Car("c");
		final Car car3 = new Car("d");
		car.move(new Power(4));
		car.move(new Power(4));
		car1.move(new Power(4));
		car2.move(new Power(4));
		values.add(car);
		values.add(car1);
		values.add(car2);
		values.add(car3);

		cars = new Cars(values);
	}

	@Test
	void getState() {
		final String expected =
			"a : --\n"
			+ "b : -\n"
			+ "c : -\n"
			+ "d : \n"
			+ "\n";

		final String actual = OutputUtils.getState(cars);
		assertEquals(expected, actual);
	}

	@Test
	void getWinners() {
		final String expected = "a";
		final String actual = OutputUtils.getWinnerState(cars);
		assertEquals(expected, actual);
	}
}