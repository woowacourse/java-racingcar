package racingcar.controller;

public class RacingController {
	CarController carController = new CarController();

	public RacingController() {
		carController.createCars("범고래,소주캉,고래");
	}

	public void run(int iteration) {
		for (int i = 0; i < iteration; i++) {
			carController.run();
		}
	}

}
