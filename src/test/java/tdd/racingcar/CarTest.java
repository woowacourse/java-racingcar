package tdd.racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private Car car;

	@BeforeEach
	void init() {
		car = new Car();
	}

	@Test
	void getPosition() {
		final int expected = 0;
		final int actual = car.getPosition();
		assertEquals(expected, actual);
	}
}
