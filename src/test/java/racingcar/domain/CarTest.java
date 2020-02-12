package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
