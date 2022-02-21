package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("자동차 전진")
	public void goTest() {
		Car car = Car.of("pobi");
		car.move(4);

		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	@DisplayName("자동차 정지")
	public void stopTest() {
		Car car = Car.of("pobi");
		car.move(2);

		assertThat(car.isSamePosition(0)).isTrue();
	}

	@Test
	@DisplayName("자동차 이름길이 정상")
	public void correctLengthOfNameTest() {
		Car.of("lala");
	}

	@Test
	@DisplayName("자동차 이름 길이 초과 예외")
	public void overLengthOfNameTest() {
		Assertions.assertThatThrownBy(() -> {
				Car.of("lalaland");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1~5글자여야 합니다.");
	}

	@Test
	@DisplayName("자동차 이름 길이 빈문자열 예외")
	public void emptyNameTest() {
		Assertions.assertThatThrownBy(() -> {
				Car.of("");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1~5글자여야 합니다.");
	}
}
