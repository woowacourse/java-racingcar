package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 이름으로_자동차를_생성한다() {
		String expectedName = "slow";

		Car car = new Car(new Name("slow"));

		assertThat(car.getName().getName()).isEqualTo(expectedName);
	}

	@Test
	void 자동차는_랜덤값이_4이상_일때_전진한다() {
		Car car = new Car(new Name("slow"));
		final int numberOfGoForward = 5;

		int firstLocation = car.getLocation();
		car.goForwardOrStop(numberOfGoForward);
		int nextLocation = car.getLocation();

		assertThat(firstLocation + 1).isEqualTo(nextLocation);
	}

	@Test
	void 자동차는_랜덤값이_4보다_작을때_멈춘다() {
		Car car = new Car(new Name("slow"));
		final int numberOfImpossibleGoForward = 3;

		int firstLocation = car.getLocation();
		car.goForwardOrStop(numberOfImpossibleGoForward);
		int nextLocation = car.getLocation();

		assertThat(firstLocation).isEqualTo(nextLocation);
	}
}
