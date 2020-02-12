package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String CAR_NAME = "name";
	private static final String TOO_LONG_NAME = "tooLongName";

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
		final Power power = new Power(4);
		final int previousPosition = car.getPosition();
		car.move(power);
		final int currentPosition = car.getPosition();
		final int expectedPosition = previousPosition + 1;
		assertEquals(expectedPosition, currentPosition);
	}

	@Test
	void moveForNotEnoughPower() {
		final Power power = new Power(3);
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

	@Test
	void canValidateName() {
		assertThatIllegalArgumentException().isThrownBy(() ->
				new Car(TOO_LONG_NAME))
				.withMessage("이름은 최대 5자까지 가능합니다.");
	}
}
