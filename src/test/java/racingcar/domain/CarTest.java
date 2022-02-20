package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Car.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	@DisplayName("자동차 이름으로 클래스가 생성되는지 테스트")
	void carGenerate() {
		String name = "pobi";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("이름이 5자 초과일 경우")
	void longName() {
		assertThatThrownBy(() -> new Car("summer"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_LONG_NAME);
	}

	@Test
	@DisplayName("빈 이름이 주어지거나 입력값이 없을 경우")
	void emptyName() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_EMPTY_NAME);
	}

	@Test
	@DisplayName("자동차가 전진하는지 테스트")
	void carMoveForward() {
		String name = "pobi";
		Car car = new Car(name);
		car.moveForward();
		assertThat(car.isSamePosition(1)).isTrue();
	}
}