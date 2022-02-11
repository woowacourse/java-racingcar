package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.domain.strategy.MovingStrategy;

public class CarTest {

	@Test
	@DisplayName("자동차가 움직인다")
	public void car_move() {
		// given
		MovingStrategy movingStrategy = () -> true;
		Car car = new Car("foo", movingStrategy);

		// when & then
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차가 움직이지 않는다")
	public void car_not_move() {
		// given
		MovingStrategy movingStrategy = () -> false;
		Car car = new Car("foo", movingStrategy);

		// when & then
		car.move();
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
