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

	@Test
	void 이름_5글자_초과() {
		assertThatThrownBy(() -> {
			Car car = new Car("소주캉범고래");
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 이름_빈문자열() {
		assertThatThrownBy(() -> {
			String name = null;
			Car car = new Car(name);
		}).isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> {
			Car car = new Car("");
		}).isInstanceOf(RuntimeException.class);
	}


}
