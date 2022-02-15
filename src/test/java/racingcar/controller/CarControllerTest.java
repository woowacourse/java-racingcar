package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarControllerTest {

	@Test
	@DisplayName("자동차 이름을 ,로 구분하여 공백을 제거 후 String[]로 반환한다.")
	void splitCarNames() {
		CarController carController = new CarController();
		String userInputCarNames = "  범고래, 소주캉,   고래  ";

		String[] expected = {"범고래", "소주캉", "고래"};
		assertThat(carController.splitCarNames(userInputCarNames)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"범고래,범고래,고래", "중복 자동차이름, 중복 자동차이름, 고래"})
	@DisplayName("중복된 자동차 이름 값을 넣으면 예외가 발생한다.")
	void validDuplicationCarNames(String input) {
		CarController carController = new CarController();

		assertThatThrownBy(() -> carController.createCars(input)).isInstanceOf(RuntimeException.class)
				.hasMessageContaining("중복");
	}
}
