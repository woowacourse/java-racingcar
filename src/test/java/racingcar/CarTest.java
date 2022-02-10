package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void 자동차_생성() {
		Car car = new Car("소주캉");
		assertThat(car.getName()).isEqualTo("소주캉");
	}

	@Test
	void 자동차_초기위치() {
		Car car = new Car("소주캉");
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
