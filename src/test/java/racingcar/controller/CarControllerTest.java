package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarControllerTest {

	@Test
	@DisplayName("자동차 이름 콤마 기준 분리, 공백 제거")
	void splitCarNamesTest() {
		CarController carController = new CarController();
		List<String> expected = Arrays.asList("범고래", "소주캉", "고래");
		String userInputCarNames = "  범고래 , 소주캉,   고래";

		assertThat(carController.splitCarNames(userInputCarNames)).isEqualTo(expected);
	}

	@Test
	@DisplayName("3대의 자동차 목록 생성 테스트")
	void createCarsTest() {
		CarController carController = new CarController();
		String userInputCarNames = "범고래,소주캉,고래";
		carController.createCars(userInputCarNames);

		assertThat(carController.getCars().size()).isEqualTo(3);
	}
}
