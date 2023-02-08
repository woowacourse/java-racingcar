package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

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

	@Nested
	class carMoveTest {
		Car car = new Car("woowa");
		@Test
		@DisplayName("4 이상의 값이 입력되면 차의 위치가 1 증가해야 한다.")
		void carMoveTest() {
			final int number = 4;
			assertTrue(car.move(number));
		}

		@Test
		@DisplayName("3 이하의 값이 입력되면 차의 위치가 유지되어야 한다.")
		void carNotMoveTest() {
			final int number = 3;
			assertFalse(car.move(number));
		}
	}
}
