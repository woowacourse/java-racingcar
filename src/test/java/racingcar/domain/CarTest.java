package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

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
