package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarTest {

	@Test
	@DisplayName("자동차 생성 빈 이름일 때 예외")
	public void createCarWithEmptyName() {
		assertThatThrownBy(() -> Car.from(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 생성 이름 6자 이상일 때 예외")
	public void createCarWithLengthOver() {
		assertThatThrownBy(() -> Car.from("abcdef"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 생성 position 음수일 때 예외")
	public void createCarPositionWithNegative() {
		assertThatThrownBy(() -> Car.of("abcde", -1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 전진")
	public void moveCar() {
		Car car = Car.from("pobi");
		car.move(4);

		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	@DisplayName("자동차 정지")
	public void stopCar() {
		Car car = Car.from("pobi");
		car.move(2);

		assertThat(car.isSamePosition(0)).isTrue();
	}
}
