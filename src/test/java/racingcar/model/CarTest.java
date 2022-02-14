package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.utlis.RandomNumberGenerator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	static final int MOVE_CRITERIA = 4;

	@DisplayName("Car 생성자 테스트")
	@Test
	void createCarTest() {
		//given
		String name = "주디";
		int position = 3;
		//when
		Car actualCar = new Car(name, position);
		//then
		assertThat(actualCar.getName()).isEqualTo(name);
		assertThat(actualCar.getPosition()).isEqualTo(position);
	}

	@Test
	void decideMoveCarTest() {
		//given
		Car car = new Car("주디", 0);
		boolean situation = isMove();
		//when
		if (situation) {
			car = new Car("주디", 1);
		}
		//then
		if (situation) {
			assertThat(car.getPosition()).isEqualTo(1);
		} else {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	boolean isMove() {
		return getRandomInt() >= MOVE_CRITERIA;
	}

}