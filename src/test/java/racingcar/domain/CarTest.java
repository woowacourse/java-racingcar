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
	private static final int CAR_MOVE_MIN = 4;
	private static final int CAR_UNMOVED_POS = 0;
	private static final int CAR_SINGLE_MOVED_POS = 1;

	@Nested
	class carInitTest {

		@Test
		@DisplayName("5자 이하의 이름인 경우 정상적으로 생성되어야 한다.")
		void carInitSuccessTest() {
			final String name = "abcde";
			Car car = new Car(name);
		}

		@Test
		@DisplayName("5자 초과의 이름인 경우 IllegalArgumentException을 발생시켜야 한다.")
		void carInitFailTest() {
			final String name = "abcdef";

			assertThatThrownBy(() -> new Car(name))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@ParameterizedTest
	@DisplayName("4 이상의 값이 입력되면 차의 위치가 1 증가해야 하고, 4 미만의 값이 입력되면 차의 위치가 유지되어야 한다.")
	@MethodSource("carMoveTestSource")
	void carMoveTest(final int number, final int expected) {
		Car car = new Car("woowa");
		car.move(number);

		assertThat(car.getPosition()).isEqualTo(expected);
	}

	private static Stream<Arguments> carMoveTestSource() {
		return Stream.of(
			Arguments.of(CAR_MOVE_MIN, CAR_SINGLE_MOVED_POS),
			Arguments.of(CAR_MOVE_MIN - 1, CAR_UNMOVED_POS),
			Arguments.of(CAR_MOVE_MIN + 1, CAR_SINGLE_MOVED_POS)
		);
	}

	@Test
	@DisplayName("차 객체의 위치 정보가 움직인만큼 문자열로 출력되어야 한다.")
	void toStringTest() {
		Car car = new Car("woowa");
		car.move(CAR_MOVE_MIN);
		car.move(CAR_MOVE_MIN);

		assertThat(car.printCarNameWithPosition()).isEqualTo("woowa : ---");
	}
}
