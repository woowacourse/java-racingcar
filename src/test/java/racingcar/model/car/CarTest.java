package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스")
public class CarTest {
	@Nested
	@DisplayName("move 메소드는")
	class Move {
		@Test
		@DisplayName("1칸 이동할 수 있다.")
		void it_increase_position() {
			Car car = Car.of("car", 0);
			car.move();
			assertThat(car.toDto().getPosition()).isEqualTo(1);
		}
	}
}
