package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	@Test
	public void 자동차_생성() {
		// given
		String name = "test1";

		// when
		Car car = new Car(name);

		// then
		assertThat(car).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "123456", " "})
	public void 자동차_생성_실패(String name) {
		// then
		assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 전진() {
		// given
		int random = 5;
		Car car = new Car("test");

		// when
		car.go(random);

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void 전진_실패() {
		// given
		int random = 3;
		Car car = new Car("test");

		// when
		car.go(random);

		// then
		assertThat(car.getPosition()).isEqualTo(0);
	}
}