package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.service.MovingCondition;

public class CarTest {

	@Test
	public void 전진_테스트() {
		MovingCondition movingCondition = () -> true;
		Car car = new Car("아스피", movingCondition);
		car.move();
		assertThat(car.isSamePosition(new Car("배카라", 1))).isEqualTo(true);
	}

}
