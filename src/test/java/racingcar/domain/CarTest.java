package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

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
	@DisplayName("자동차가 전진하는지 테스트")
	void carMoveForward() {
		String name = "pobi";
		Car car = new Car(name);
		car.moveForward();
		assertThat(car.isSamePosition(1)).isTrue();
	}
}