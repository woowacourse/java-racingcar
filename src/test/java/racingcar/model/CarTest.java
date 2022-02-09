package racingcar.model;

import static org.assertj.core.api.Assertions.*;

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
}