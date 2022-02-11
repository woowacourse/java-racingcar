package racingcar.controller;

import java.util.ArrayList;
import java.util.Random;

import racingcar.model.Car;
import racingcar.util.IntegerConst;

public class CarListController {
	private int generateRandNum() {
		Random random = new Random();
		return random.nextInt(IntegerConst.RANDOM_UPPER_BOUND.getValue());
	}

	public void moveCarList(CarList carList) {
		ArrayList<Integer> randomNumberArray = new ArrayList<>();
		for (int index = 0; index < carList.getSize(); index++) {
			randomNumberArray.add(generateRandNum());
		}
		carList.moveCars(randomNumberArray);
	}
}
