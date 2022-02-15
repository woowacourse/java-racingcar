package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

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

	@Test
	public void 자동차_이름_길이_정상() {
		Car.from("lala");
	}

	@Test
	public void 자동차_이름_길이_초과_예외() {
		Assertions.assertThatThrownBy(() -> {
				Car.from("lalaland");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1~5글자여야 합니다.");
	}

	@Test
	public void 자동차_이름_길이_빈문자열_예외() {
		Assertions.assertThatThrownBy(() -> {
				Car.from("");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1~5글자여야 합니다.");
	}
}
