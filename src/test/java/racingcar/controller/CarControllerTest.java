package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Splitter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarControllerTest {

	@ParameterizedTest
	@ValueSource(strings = {"범고래,범고래,고래", "중복 자동차이름, 중복 자동차이름, 고래"})
	@DisplayName("중복된 자동차 이름 값을 넣으면 예외가 발생한다.")
	void validDuplicationCarNames(String input) {
		CarController carController = new CarController();

		assertThatThrownBy(() -> carController.createCars(Splitter.split(input))).isInstanceOf(RuntimeException.class)
				.hasMessageContaining("중복");
	}
}
