package tdd.racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarFactoryTest {
	@Test
	void createCar() {
		final List<String> names = new ArrayList<>();
		names.add("a");
		names.add("b");
		names.add("c");
		names.add("d");

		final List<Car> cars = CarFactory.create(names);
		assertEquals(names.size(), cars.size());
	}
}
