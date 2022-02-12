package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 위치 일치 여부 테스트")
	void isSamePositionTest() {
		Car car = new Car("소주캉");
		assertThat(car.isSamePosition(0)).isTrue();
	}

	@Test
	@DisplayName("자동차 이름 5자 초과 검증 테스트")
	void isOverNameLengthTest() {
		assertThatThrownBy(() -> {
			Car car = new Car("소주캉범고래");
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름 빈 문자열 검증 테스트")
	void isEmptyNameTest() {
		assertThatThrownBy(() -> {
			Car car = new Car("");
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름 null 검증 테스트")
	void isNullNameTest() {
		assertThatThrownBy(() -> {
			Car car = new Car(null);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이동 테스트")
	void moveTest() {
		Car car = new Car("범고래");
		car.move(4);
		assertThat(car.isSamePosition(1)).isTrue();
	}
}
