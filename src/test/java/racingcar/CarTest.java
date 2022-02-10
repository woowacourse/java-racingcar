package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarTest {

	@Test
	public void 자동차_전진() {
		Car car = Car.of("pobi");
		car.move(4);

		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	public void 자동차_정지() {
		Car car = Car.of("pobi");
		car.move(2);

		assertThat(car.isSamePosition(0)).isTrue();
	}
}
