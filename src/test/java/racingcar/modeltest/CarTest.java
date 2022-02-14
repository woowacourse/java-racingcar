package racingcar.modeltest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class CarTest {

	@Test
	public void 전진_테스트() {
		Car car = new Car("아스피");
		car.move(4);
		String result = car.testMoveFunction(1);
		assertThat(result).isEqualTo("Success!!");
	}

	@Test
	public void 전진_조건() {
		Car car = new Car("아스피");
		boolean result = car.checkMovingCondition(4);
		assertThat(result).isEqualTo(true);
	}
}
