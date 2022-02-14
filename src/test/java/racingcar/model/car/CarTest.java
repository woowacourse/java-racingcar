package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@DisplayName("1칸 이동할 수 있다.")
	@Test
	void move() {
		Car car = Car.of("car", 0);
		car.move();
		assertThat(car.toDto().getPosition()).isEqualTo(1);
	}
}
