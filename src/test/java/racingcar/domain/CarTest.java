package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.strategy.MovingStrategy;

@DisplayName("자동차 도메인 TEST")
public class CarTest extends Car {

	@Nested
	@DisplayName("자동차 움직임(Moving)")
	class MovingTest {
		@Test
		@DisplayName("움직일 때")
		public void car_move() {
			// given
			Car car = Car.createFixedMovingCar("foo");

			// when & then
			car.move();
			assertThat(car.getPosition()).isEqualTo(1);
		}

		@Test
		@DisplayName("움직이지 않을 때")
		public void car_not_move() {
			// given
			MovingStrategy movingStrategy = () -> false;
			Car car = new Car("foo", movingStrategy);

			// when & then
			car.move();
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@Nested
	@DisplayName("자동차 이름에 ")
	class CarNameTest {

		@ParameterizedTest
		@ValueSource(strings = {",", "#", "panda,", "#philz", ",phobi,"})
		@DisplayName("허용되지 않는 문자를 입력했을 때")
		public void Not_Available_Character(String carName) {
			assertThatThrownBy(
				() -> Car.createRandomMovingCar(carName)
			).isInstanceOf(RuntimeException.class);
		}

		@Test
		@DisplayName("null을 입력했을 때")
		public void Not_Available_Null() {
			assertThatThrownBy(
				() -> Car.createRandomMovingCar(null)
			).isInstanceOf(RuntimeException.class);
		}

		@ParameterizedTest
		@ValueSource(strings = {"a", "aa", "philz"})
		@DisplayName("정상 입력을 했을 때")
		public void Available_Character(String carName) {
			Assertions.assertDoesNotThrow(
				() -> Car.createRandomMovingCar(carName)
			);
		}
	}
}
