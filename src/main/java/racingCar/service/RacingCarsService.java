package racingCar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.RoundCount;
import racingCar.model.RacingCars;
import racingCar.utlis.Util;
import racingCar.view.Output;

public class RacingCarsService {
	private RacingCars cars;
	private RoundCount roundCount;

	public void initiateCars(String nameString) {
		String[] names = Util.separate(nameString);
		cars = new RacingCars(new ArrayList<>(Arrays.asList(names)));
	}

	public void initiateCount(int countInput) {
		roundCount = new RoundCount(countInput);
	}

	public void runGame() {
		goRound();
		if (roundCount.isFinish()) {
			return;
		}
		runGame();
	}

	public void goRound() {
		cars.goRound();
		roundCount.goRound();
		Output.printRoundResult(cars);
	}

	public List<String> findWinner() {
		return cars.getSamePositionCars(cars.getMaxPosition());
	}
}