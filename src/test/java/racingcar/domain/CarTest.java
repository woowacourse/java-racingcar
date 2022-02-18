package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.domain.strategy.FixedMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;

@DisplayName("자동차 도메인 TEST")
public class CarTest {

	@Nested
	@DisplayName("자동차 움직임(Moving)")
	class MovingTest {
		@Test
		@DisplayName("움직일 때 위치는 +1 이 된다")
		public void car_move() {
			// given
			final Car car = Car.builder()
				.position(0)
				.movingStrategy(new FixedMovingStrategy())
				.build();

			final Car movedCar = Car.builder()
				.position(1)
				.build();

			// when & then
			car.move();
			assertThat(car.isSamePosition(movedCar)).isTrue();
		}

		@Test
		@DisplayName("움직이지 않을 때 위치는 그대로다")
		public void car_not_move() {
			// given
			final MovingStrategy notMoving = () -> false;

			final Car car = Car.builder()
				.position(0)
				.movingStrategy(notMoving)
				.build();

			final Car notMovedCar = Car.builder()
				.position(0)
				.build();

			// when & then
			car.move();
			assertThat(car.isSamePosition(notMovedCar)).isTrue();
		}
	}
}
