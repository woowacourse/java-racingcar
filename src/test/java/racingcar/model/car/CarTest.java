package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {
	@DisplayName("move 메소드는")
	@Nested
	class move {
		@Test
		void 전진_조건_만족한다면() {
			Car car = Car.of("car", 0, (min, max) -> 10);
			car.move();
			assertThat(car.getPosition().toInt()).isEqualTo(1);
		}

		@Test
		void 전진_조건_만족못한다면() {
			Car car = Car.of("car", 0, (min, max) -> 3);
			car.move();
			assertThat(car.getPosition().toInt()).isEqualTo(0);
		}
	}
}
