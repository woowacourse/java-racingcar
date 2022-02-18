package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Cars.*;
import static racingcar.domain.vo.CarName.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.strategy.FixedMovingStrategy;

class CarsTest {

	@DisplayName("자동차들을 생성시 이름에")
	@Nested
	class CarNamesTest {
		@ParameterizedTest
		@ValueSource(strings = {"panda,philz,jav#a", "aaa, bb@bb, cc"})
		@DisplayName("허용되지 않는 문자를 입력했을 때 예외 발생")
		public void input_all_car_name_exception(String carNames) {
			assertThatThrownBy(
				() -> new Cars(carNames))
				.isInstanceOf(RuntimeException.class)
				.hasMessage(NOT_ALLOWED_FORMAT_MESSAGE);
		}

		@ParameterizedTest
		@ValueSource(strings = {"aa,aa,bb", " a, bb, c, a"})
		@DisplayName("이름에 중복이 들어가면 예외가 발생한다")
		public void not_duplicate_names(String carNames) {
			assertThatExceptionOfType(RuntimeException.class).isThrownBy(
					() -> new Cars(carNames))
				.withMessage(INVALID_DUPLICATE_CAR_NAMES);
		}

		@ParameterizedTest
		@ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
		@DisplayName("정상 값을 입력했을 때 예외가 발생하지 않는다")
		public void input_all_car_name(String carNames) {
			Assertions.assertDoesNotThrow(
				() -> new Cars(carNames)
			);
		}
	}

	@DisplayName("우승자가")
	@Nested
	class WinnerTest {

		private Car car1;
		private Car car2;
		private Car car3;

		@BeforeEach
		void setUp() {
			// given
			car1 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
			car2 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
			car3 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
		}

		@Test
		@DisplayName("한명일 때")
		public void Only_One_Winner() {
			// when
			car1.move(3);
			car2.move(1);
			car3.move(2);

			Cars cars = new Cars(List.of(car1, car2, car3));
			List<Car> winners = cars.getWinners();

			// then
			assertThat(winners).containsExactly(car1);
		}

		@Test
		@DisplayName("여러명일 때")
		public void Two_Or_More_Winners() {
			// when
			car1.move(3);
			car2.move(1);
			car3.move(3);

			Cars cars = new Cars(List.of(car1, car2, car3));
			List<Car> winners = cars.getWinners();

			// then
			assertThat(winners).containsExactly(car1, car3);
		}
	}
}
