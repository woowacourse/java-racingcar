package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarTest {

	@Test
	public void 자동차_전진() {
		Car car = Car.of("pobi");

		int beforePoint = car.getPosition();
		car.move(4);
		int afterPoint = car.getPosition();

		assertThat(beforePoint + 1).isEqualTo(afterPoint);
	}

	@Test
	public void 자동차_정지() {
		Car car = Car.of("pobi");

		int beforePoint = car.getPosition();
		car.move(2);
		int afterPoint = car.getPosition();

		assertThat(beforePoint).isEqualTo(afterPoint);
	}
}
