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

	public void moveCarList(ArrayList<Car> carList) {
		ArrayList<Integer> randomNumberArray = new ArrayList<>();
		for (int index = 0; index < carList.size(); index++) {
			randomNumberArray.add(generateRandNum());
		}
		for (int index = 0; index < carList.size(); index++) {
			carList.get(index).movePosition(randomNumberArray.get(index));
		}
	}
}
