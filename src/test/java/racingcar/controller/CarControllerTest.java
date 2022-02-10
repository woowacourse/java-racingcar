package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import racingcar.model.CarRepository;

public class CarControllerTest {


	@Test
	void 자동차_이름_파싱() {
		CarController carController = new CarController();
		String userInputCarNames = "  범고래, 소주캉,   고래  ";

		String[] expected = {"범고래", "소주캉", "고래"};
		assertThat(carController.splitCarNames(userInputCarNames)).isEqualTo(expected);
	}

	@Test
	void 자동차_3대_생성() {
		CarController carController = new CarController();
		String userInputCarNames = "범고래,소주캉,고래";
		carController.createCars(userInputCarNames);

		CarRepository repository = CarRepository.getInstance();
		assertThat(repository.size()).isEqualTo(3);
	}

	@AfterEach
	void afterEach() {
		CarRepository repository = CarRepository.getInstance();
		repository.clear();
	}
}
