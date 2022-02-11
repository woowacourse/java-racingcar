package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
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
		goOrStop_테스트(6, 1);
	}

	@Test
	public void 정지() {
		goOrStop_테스트(3, 0);
	}

	private void goOrStop_테스트(int random, int expected) {
		// given
		Car car = new Car("test");

		// when
		car.goOrStop(random);

		// then
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	public void toString_체크() {
		// given
		Car car = new Car("test");

		// when
		car.goOrStop(6);

		// then
		assertThat(car.toString()).isEqualTo("test : -");
	}
}