package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String CAR_NAME = "name";
	private static final String TOO_LONG_NAME ="tooLongName";

	private Car car;

	@BeforeEach
	void init() {
		car = new Car(CAR_NAME);
	}

	@Test
	void getPosition() {
		final Position expected = new Position(0);
		final Position actual = car.getPosition();
		assertEquals(expected, actual);
	}

	@Test
	void moveForEnoughPower() {
		final Power power = new Power(4);
		car.move(power);
		final Position actualPosition = car.getPosition();
		final Position expectedPosition = new Position(1);
		assertEquals(expectedPosition, actualPosition);
	}

	@Test
	void moveForNotEnoughPower() {
		final Power power = new Power(3);
		final Position previousPosition = car.getPosition();
		car.move(power);
		final Position currentPosition = car.getPosition();
		assertEquals(currentPosition, previousPosition);
	}

	@Test
	void getName() {
		final Name actual = car.getName();
		assertEquals(CAR_NAME, actual.toString());
	}

	@Test
	void canValidateName() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new Car(TOO_LONG_NAME))
			.withMessage("이름은 최대 5자까지 가능합니다.");
	}
}
