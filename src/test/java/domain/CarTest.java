package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.strategy.MovingStrategy;

class CarTest {

	@DisplayName("canMove()가 true를 반환했을때의 차량 전진 확인")
	@Test
	void move_CanMove() {
		MovingStrategy movingStrategy = getTestMovingStrategy(true);
		Car car = new Car("abc", 0, movingStrategy);
		car.move();

		assertThat(car.getCarLocation()).isEqualTo(1);
	}

	@DisplayName("canMove()가 false를 반환했을때의 차량 정지 확인")
	@Test
	void move_CannotMove() {
		MovingStrategy movingStrategy = getTestMovingStrategy(false);
		Car car = new Car("abc", 0, movingStrategy);
		car.move();

		assertThat(car.getCarLocation()).isEqualTo(0);
	}

	private MovingStrategy getTestMovingStrategy(boolean desiredResult) {
		return new MovingStrategy() {
			@Override
			public boolean canMove() {
				return desiredResult;
			}
		};
	}
}
