package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 자동차_초기위치() {
		Car car = new Car("소주캉");
		assertThat(car.matchPosition(0)).isTrue();
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
			Car car = new Car("");
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 이름_null() {
		assertThatThrownBy(() -> {
			Car car = new Car(null);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 자동차_이동() {
		Car car = new Car("범고래");
		car.move(4);
		assertThat(car.matchPosition(1)).isTrue();
	}

	@Test
	void 값이_더_큰_포지션_반환() {
		Car car = new Car("범고래");
		car.move(4);
		assertThat(car.getBiggerPosition(0)).isEqualTo(1);
	}
}
