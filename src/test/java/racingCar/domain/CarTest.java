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
	void moveCarTest() {
		car.moveCar(true);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("승자 확인 테스트")
	void isWinnerTest() {
		car.moveCar(true);
		car.moveCar(true);
		assertThat(car.isWinner(3)).isEqualTo(false);
	}
}
