package racingcar;

import java.util.ArrayList;

import racingcar.controller.RacingCarsController;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class Application {
	public static void main(String[] args) {
		Cars cars = new Cars(new ArrayList<>());
		Winners winners = new Winners();
		RacingCarsController racingCarsController = new RacingCarsController(cars, winners);
		racingCarsController.run();
	}
}
