package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingControllerTest {

	@Test
	@DisplayName("자동차 이름 콤마 기준 분리, 공백 제거")
	void splitCarNamesTest() {
		RacingController racingController = new RacingController();
		List<String> expected = Arrays.asList("범고래", "소주캉", "고래");
		String userInputCarNames = "  범고래 , 소주캉,   고래";

		assertThat(racingController.splitCarNames(userInputCarNames)).isEqualTo(expected);
	}

	@Test
	@DisplayName("3대의 자동차 목록 생성 테스트")
	void createCarsTest() {
		RacingController racingController = new RacingController();
		String userInputCarNames = "범고래,소주캉,고래";
		racingController.createCars(userInputCarNames);

		assertThat(racingController.getCars().size()).isEqualTo(3);
	}
}
