package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.vo.CarName.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Nested
	@DisplayName("자동차 이름에 ")
	class CarNameTest {

		@ParameterizedTest
		@ValueSource(strings = {",", "#", "#phiz", "ph,bi"})
		@DisplayName("허용되지 않는 문자를 입력했을 때 예외가 발생한다")
		public void Not_Available_Character(String carName) {
			assertThatThrownBy(
				() -> Car.builder()
					.name(carName)
					.build())
				.isInstanceOf(RuntimeException.class)
				.hasMessage(NOT_ALLOWED_FORMAT_MESSAGE);

		}

		@Test
		@DisplayName("null을 입력했을 때 예외가 발생한다")
		public void Not_Available_Null() {
			assertThatThrownBy(
				() -> Car.builder()
					.name(null)
					.build())
				.isInstanceOf(RuntimeException.class)
				.hasMessage(INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER);
		}

		@Test
		@DisplayName("차 이름이 5글자를 넘어갔을 경우 예외가 발생한다")
		public void input_car_name_exceed_length() {
			assertThatThrownBy(
				() -> Car.builder()
					.name("abcdef")
					.build())
				.isInstanceOf(RuntimeException.class)
				.hasMessage(EXCEED_LENGTH_ERROR_MESSAGE);
		}

		@ParameterizedTest
		@ValueSource(strings = {"a", "aa", "philz"})
		@DisplayName("정상 입력을 했을 때 예외가 발생하지 않는다")
		public void Available_Character(String carName) {
			Assertions.assertDoesNotThrow(
				() -> Car.builder()
					.name(carName)
					.build());
		}
	}
}
