package racingCar.service;

import static racingCar.view.Output.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.Count;
import racingCar.model.RacingCars;
import racingCar.utlis.Util;
import racingCar.view.Output;

public class RacingCarsService {
	private static RacingCars cars;
	private static Count count;

	public static void initiateCars(String nameString) {
		String[] names = Util.separate(nameString);
		cars = new RacingCars(new ArrayList<>(Arrays.asList(names)));
	}

	public static void initiateCount(int countInput) {
		count = new Count(countInput);
	}

	public static void runGame() {
		printStartMessage();
		for (int i = 0; i < count.get(); i++) {
			cars.GoRound();
			Output.printRoundResult(cars);
		}
	}

	public static List<String> findWinner() {
		return cars.getSamePositionCars(cars.getMaxPosition());
	}
}