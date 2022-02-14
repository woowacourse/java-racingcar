package racingcargame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("Car 객체가 정상적으로 생성되는지 테스트")
	@Test
	void car_objectCreate() {
		String name = "토미";
		int position = 3;
		Car car = new Car(name, position);

		assertThat(car.getName()).isEqualTo("토미");
		assertThat(car.getPosition()).isEqualTo(3);
	}

	@DisplayName("난수값에 따라 자동차의 position값이 바뀌는지 테스트")
	@Test
	void moveCar() {
		String name = "토미";
		int position = 3;
		Car car = new Car(name, position);

		int moveNumber = car.moveCar();

		if (moveNumber >= 4) {
			assertThat(car.getPosition()).isEqualTo(4);
		}
		if (moveNumber < 4) {
			assertThat(car.getPosition()).isEqualTo(3);
		}
	}
}
