package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

	private static Car car;

	@BeforeEach
	void init() {
		car = new Car("carA");
	}

	@Test
	void 자동차_전진() {
		car.moveForward(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 자동차_멈춤() {
		car.moveForward(0);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
