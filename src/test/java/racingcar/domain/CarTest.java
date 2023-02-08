package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
		Car car;

		@BeforeEach
		void beforeEach() {
			car = new Car("woowa");
		}

		@Test
		@DisplayName("4 이상의 값이 입력되면 차의 위치가 1 증가해야 한다.")
		void carMoveTest() {
			final int number = 4;
			car.move(number);
			assertThat(car.getPosition()).isEqualTo(1);
		}

		@Test
		@DisplayName("3 이하의 값이 입력되면 차의 위치가 유지되어야 한다.")
		void carNotMoveTest() {
			final int number = 3;
			car.move(number);
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("")
	void toStringTest() {
		Car car = new Car("woowa");
		car.move(4);
		car.move(4);
		assertThat(car.toString()).isEqualTo("woowa : ---");
	}
}
