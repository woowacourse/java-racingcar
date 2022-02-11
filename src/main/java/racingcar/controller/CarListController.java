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

	private ArrayList<Integer> generateRandNumArray(int size) {
		ArrayList<Integer> randomNumberArray = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			randomNumberArray.add(generateRandNum());
		}
		return randomNumberArray;
	}

	public void moveCarList(ArrayList<Car> carList) {
		ArrayList<Integer> randomNumberArray = generateRandNumArray(carList.size());
		for (int index = 0; index < carList.size(); index++) {
			carList.get(index).movePosition(randomNumberArray.get(index));
		}
	}
}
