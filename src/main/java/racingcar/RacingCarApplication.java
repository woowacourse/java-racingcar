package racingcar;

import racingcar.controller.RacingController;

public class RacingCarApplication {

	public static void main(String[] args) {
		RacingController racingController = new RacingController();
		racingController.start();
	}
}
