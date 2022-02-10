package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingControllerTest {

	@Test
	void 자동차_경주_3회_실행() {
		RacingController racingController = new RacingController();
		racingController.run(10);
	}
}