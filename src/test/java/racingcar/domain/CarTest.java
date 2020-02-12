package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("정상적으로 생성되는 경우")
	void constructorWithoutException(String value) {
		assertThat(new Car(value));
	}

	@Test
	@DisplayName("Null인자의 경우 예외발생")
	void constructorNull() {
		assertThatThrownBy(() -> {
			new Car(null);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("길이초과의 경우 예외발생")
	void constructorOverLength() {
		assertThatThrownBy(() -> {
			new Car("moreThanFiveLetters");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"  ", "", "        "})
	@DisplayName("빈 문자열의 경우 예외발생")
	void constructorEmpty(String value) {
		assertThatThrownBy(() -> {
			new Car(value);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("정상적으로 움직이는 경우 True 반환")
	void moves() {
		Car pobiClone = new Car("pobi");
		pobi.move(GOING_NUMBER);
		pobiClone.move(GOING_NUMBER);
		assertThat(pobi.isOnSamePosition(pobiClone)).isTrue();
	}

	@Test
	@DisplayName("포지션이 같은 경우 True 반환")
	void isSamePositionTest() {
		Car anotherCar = new Car("young");
		anotherCar.move(GOING_NUMBER);
		pobi.move(GOING_NUMBER);
		assertThat(pobi.isOnSamePosition(anotherCar)).isTrue();
	}

	@Test
	@DisplayName("포지션 동점자의 이름을 반환")
	void getCoWinnersNameTest() {
		Car anotherCar = new Car("young");
		anotherCar.move(GOING_NUMBER);
		pobi.move(GOING_NUMBER);
		assertThat(pobi.getCoWinnersName(anotherCar)).isEqualTo("young");
	}

	@Test
	@DisplayName("toString()")
	void toStringTest() {
		assertThat(pobi).hasToString("pobi : \n");
		pobi.move(GOING_NUMBER);
		assertThat(pobi).hasToString("pobi : -\n");
	}
}
