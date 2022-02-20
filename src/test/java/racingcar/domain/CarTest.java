package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	@DisplayName("자동차 이름으로 클래스가 생성되는지 테스트")
	void carGenerate() {
		String name = "pobi";
		Car car = new Car(name, 0);
		assertThat(car.getName().toString()).isEqualTo(name);
	}

	@Test
	@DisplayName("자동차가 전진하는지 테스트")
	void carMoveForward() {
		String name = "pobi";
		Car car = new Car(name, 0);
		car.moveForward();
		assertThat(car.isSamePosition(new Position(1))).isTrue();
	}
}