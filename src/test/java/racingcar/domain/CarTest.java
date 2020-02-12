package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	@Test
	void getCarNameAndPosition() {
		String name = "pobi";
		int position = 0;
		Car car = new Car(name);

		assertAll(
			() -> assertEquals(name, car.getName()),
			() -> assertEquals(position, car.getPosition())
		);
	}

	@ParameterizedTest
	@CsvSource(value = {"3,0", "4,1"})
	void Should_move_when_bigger_than_3(int value, int expected) {
		Car car = new Car("pobi");

		car.move(value);

		Assertions.assertThat(car.getPosition()).isEqualTo(expected);
	}
}
