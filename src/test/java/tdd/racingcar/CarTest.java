package tdd.racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String CAR_NAME = "name";

	private Car car;

	@BeforeEach
	void init() {
		car = new Car(CAR_NAME);
	}

	@Test
	void getPosition() {
		final int expected = 0;
		final int actual = car.getPosition();
		assertEquals(expected, actual);
	}

	@Test
	void moveForEnoughPower() {
		final int power = 4;
		final int previousPosition = car.getPosition();
		car.move(power);
		final int currentPosition = car.getPosition();
		final int expectedPosition = previousPosition + 1;
		assertEquals(expectedPosition, currentPosition);
	}

	@Test
	void moveForNotEnoughPower() {
		final int power = 3;
		final int previousPosition = car.getPosition();
		car.move(power);
		final int currentPosition = car.getPosition();
		assertEquals(currentPosition, previousPosition);
	}

	@Test
	void getName() {
		final String actual = car.getName();
		assertEquals(CAR_NAME, actual);
	}
}
