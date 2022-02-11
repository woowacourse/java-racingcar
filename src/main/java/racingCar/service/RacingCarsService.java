package racingCar.service;

import static racingCar.view.Output.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.RacingCars;
import racingCar.utlis.Convertor;
import racingCar.utlis.Util;
import racingCar.validator.CountValidator;
import racingCar.view.Output;

public class RacingCarsService {

	private RacingCars cars;
	private int count;

	public void initiateCars(String nameString) throws Exception {
		cars = new RacingCars(new ArrayList<>(Arrays.asList(
			Convertor.separate(nameString)
		)));
	}

	public void initiateCount(int count) throws Exception {
		CountValidator.validateInteger(count);
		this.count = count;
	}

	public void runGame() {
		printStartMessage();
		for (int i = 0; i < count; i++) {
			cars.GoRound();
			Output.printRoundResult(cars);
		}
	}

	public List<String> findWinner() {
		return cars.getWinners(Util.getMax(cars.getPositions()));
	}
}