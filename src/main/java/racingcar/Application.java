package racingcar;

import racingcar.controller.RacingCarsController;
import racingcar.model.Winners;

public class Application {
	public static void main(String[] args) {
		Winners winners = new Winners();
		RacingCarsController racingCarsController = new RacingCarsController(winners);
		racingCarsController.run();
	}
}
