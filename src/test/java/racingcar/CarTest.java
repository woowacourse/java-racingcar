package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	public void 차_생성() {
		String name = "forky";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}
}
