package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
	@Nested
	class carInitTest {

		@Test
		@DisplayName("5자 이하의 이름인 경우 정상적으로 생성되어야 한다.")
		void carCreateSuccessTest() {
			final String name = "abcde";
			Car car = new Car(name);
		}
		@Test
		@DisplayName("입력이 공백인 경우 IllegalArgumentException을 발생시켜야 한다.")
		void carCreateBlankFailTest() {
			final String name = "   ";

			assertThatThrownBy(() -> new Car(name))
					.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("5자 초과의 이름인 경우 IllegalArgumentException을 발생시켜야 한다.")
		void carCreateLengthFailTest() {
			final String name = "abcdef";

			assertThatThrownBy(() -> new Car(name))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@ParameterizedTest
	@DisplayName("4 이상의 값이 입력되면 차의 위치가 1 증가해야 하고, 4 미만의 값이 입력되면 차의 위치가 유지되어야 한다.")
	@MethodSource("carMoveTestSource")
	void carMoveTest(int number, int expected) {
		Car car = new Car("woowa");
		car.move(number);

		assertThat(car.getPosition()).isEqualTo(expected);
	}

	private static Stream<Arguments> carMoveTestSource() {
		return Stream.of(
			Arguments.of(4, 1),
			Arguments.of(3, 0),
			Arguments.of(6, 1)
		);
	}
}
