package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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
		assertThat(actualCar.getName()).isEqualTo(new Name(name));
		assertThat(actualCar.getPosition()).isEqualTo(position);
	}

	@DisplayName("랜덤 넘버가 3이하 일 때")
	@Test
	void decideMoveCarTest_1() {
		//given
		Car car = new Car("주디", 0);
		//when
		car.decideMove(3);
		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@DisplayName("랜덤 넘버가 4이상 일 때")
	@Test
	void decideMoveCarTest_2() {
		//given
		Car car = new Car("주디", 0);
		//when
		car.decideMove(4);
		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

}