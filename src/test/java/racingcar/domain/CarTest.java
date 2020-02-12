package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	public static final int GOING_NUMBER = 5;
	private Car pobi;

	@BeforeEach
	void setUp() {
		pobi = new Car("pobi");
	}

	@ParameterizedTest
	@ValueSource(strings = {"pobi", "kyle", "hodol"})
	void constructorWithoutException(String value) {
		assertThat(new Car(value));
	}

	@Test
	void constructorNull() {
		assertThatThrownBy(() -> {
			new Car(null);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void constructorOverLengthy() {
		assertThatThrownBy(() -> {
			new Car("moreThanFiveLetters");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"  ", "", "        "})
	void constructorEmpty(String value) {
		assertThatThrownBy(() -> {
			new Car(value);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void moves() {
		Car pobiClone = new Car("pobi");
		pobi.move(GOING_NUMBER);
		pobiClone.move(GOING_NUMBER);
		assertThat(pobi.isOnSamePosition(pobiClone)).isTrue();
	}

	@Test
	void isSamePositionTest() {
		Car anotherCar = new Car("young");
		anotherCar.move(6);
		pobi.move(6);
		assertThat(pobi.isOnSamePosition(anotherCar)).isTrue();
	}

	@Test
	void getCoWinnersNameTest() {
		Car anotherCar = new Car("young");
		anotherCar.move(6);
		pobi.move(6);
		assertThat(pobi.getCoWinnersName(anotherCar)).isEqualTo("pobi");
	}

	@Test
	void toStringTest() {
		assertThat(pobi).hasToString("pobi : \n");
		pobi.move(GOING_NUMBER);
		assertThat(pobi).hasToString("pobi : -\n");
	}
}
