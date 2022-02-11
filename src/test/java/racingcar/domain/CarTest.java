package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.strategy.MovingStrategy;

public class CarTest {

	@Test
	@DisplayName("자동차가 움직인다")
	public void car_move() {
		// given
		MovingStrategy movingStrategy = () -> true;
		Car car = new Car("foo", movingStrategy);

		// when & then
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차가 움직이지 않는다")
	public void car_not_move() {
		// given
		MovingStrategy movingStrategy = () -> false;
		Car car = new Car("foo", movingStrategy);

		// when & then
		car.move();
		assertThat(car.getPosition()).isEqualTo(0);
	}

	/**
	 * 이름 테스트
	 */

	@ParameterizedTest
	@ValueSource(strings = {",", "#", "panda,", "#philz", ",phobi,"})
	@DisplayName("이름에 허용되지 않는 문자")
	public void Not_Available_Character(String carName) {
		assertThatThrownBy(() -> new Car(carName))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("이름에 허용되지 않는 문자 : null")
	public void Not_Available_Null() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "aa", "philz"})
	@DisplayName("자동차: 정상 입력")
	public void Available_Character(String carName) {
		Assertions.assertDoesNotThrow(() -> new Car(carName));
	}

	@ParameterizedTest
	@ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
	@DisplayName("자동차 전체 입력 : 정상")
	public void input_all_car_name(String carNames) {
		Assertions.assertDoesNotThrow(() -> new Cars(carNames));
	}

	@Test
	@DisplayName("자동차 전체 입력 : 예외")
	public void input_all_car_name_exception() {
		assertThatThrownBy(() -> Assertions.assertDoesNotThrow(() -> new Cars("panda,philz,javajigi")));
	}
}
