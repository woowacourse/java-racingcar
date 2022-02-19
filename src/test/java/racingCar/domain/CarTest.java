package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	private Car car;

	@BeforeEach
	@DisplayName("Car 객체 생성")
	void setup() {
		car = new Car("test");
	}

	@Test
	@DisplayName("Car 이동 확인")
	void moveCarMoveTest() {
		car.moveCar(true);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("Car 정지 확인")
	void moveCarStopTest() {
		car.moveCar(false);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("승자 확인 테스트")
	void isWinnerTest() {
		car.moveCar(true);
		car.moveCar(true);
		car.moveCar(true);
		assertThat(car.isWinner(3)).isEqualTo(true);
	}

	@Test
	@DisplayName("승자가 아닌 경우 테스트")
	void isNotWinnerTest() {
		car.moveCar(true);
		car.moveCar(true);
		assertThat(car.isWinner(3)).isEqualTo(false);
	}
}
