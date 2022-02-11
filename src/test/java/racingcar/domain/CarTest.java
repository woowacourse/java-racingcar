package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.strategy.MovingStrategy;

@DisplayName("자동차 도메인 TEST")
public class CarTest {
	
	@Nested
	@DisplayName("자동차 움직임 : ")
	class MovingTest {
		@Test
		@DisplayName("움직일 때")
		public void car_move() {
			// given
			MovingStrategy movingStrategy = () -> true;
			Car car = new Car("foo", movingStrategy);

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
			assertThatThrownBy(() -> new Car(carName))
				.isInstanceOf(RuntimeException.class);
		}

		@Test
		@DisplayName("null을 입력했을 때")
		public void Not_Available_Null() {
			assertThatThrownBy(() -> new Car(null))
				.isInstanceOf(RuntimeException.class);
		}

		@ParameterizedTest
		@ValueSource(strings = {"a", "aa", "philz"})
		@DisplayName("정상 입력을 했을 때")
		public void Available_Character(String carName) {
			Assertions.assertDoesNotThrow(() -> new Car(carName));
		}

	}
	@Nested
	@DisplayName("자동차들을 생성시 이름에 ")
	class CarNamesTest {
		@Test
		@DisplayName("허용되지 않는 문자를 입력했을 때")
		public void input_all_car_name_exception() {
			assertThatThrownBy(
				() -> Assertions.assertDoesNotThrow(() -> new Cars("panda,philz,javajigi"))
			);
		}

		@ParameterizedTest
		@ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
		@DisplayName("정상 값을 입력했을 때")
		public void input_all_car_name(String carNames) {
			Assertions.assertDoesNotThrow(
				() -> new Cars(carNames)
			);
		}
	}
}
