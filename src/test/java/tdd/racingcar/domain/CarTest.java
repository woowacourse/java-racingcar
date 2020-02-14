package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void getPosition() {
		Car car = new Car("핀", 10);
		assertThat(car.getPosition()).isEqualTo(10);
	}

	@Test
	void moveForEnoughPower() {
		Car car = new Car("핀", 0);
		int current = car.getPosition() + 1;
		car.move(new Power(4));
		int next = 1;
		assertThat(current).isEqualTo(next);
	}

	@Test
	void getName() {
		Car car = new Car("핀");
		assertThat(car.getName()).isEqualTo("핀");
	}

	@Test
	void canValidateName() {
		assertThatIllegalArgumentException().isThrownBy(() ->
				new Car("너무긴이름이다우와"))
				.withMessage("이름은 최대 5자까지 가능합니다.");
	}
}
