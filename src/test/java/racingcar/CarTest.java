package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarTest {

	@Test
	public void 자동차_생성_빈이름() {
		assertThatThrownBy(() -> Car.from(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_생성_이름_6자_이상() {
		assertThatThrownBy(() -> Car.from("abcdef"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_생성_position_음수() {
		assertThatThrownBy(() -> Car.of("abcde", -1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_전진() {
		Car car = Car.from("pobi");
		car.move(4);

		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	public void 자동차_정지() {
		Car car = Car.from("pobi");
		car.move(2);

		assertThat(car.isSamePosition(0)).isTrue();
	}
}
