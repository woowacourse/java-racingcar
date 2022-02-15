package racingcar.controller;

import java.util.ArrayList;
import java.util.Random;

import racingcar.model.Car;
import racingcar.model.RandomNumberList;
import racingcar.util.IntegerConst;

public class CarListController {

	public void moveCarList(ArrayList<Car> carList) {
        RandomNumberList randomNumberList = new RandomNumberList(carList.size());
		for (int index = 0; index < carList.size(); index++) {
			carList.get(index).movePosition(randomNumberList.getNumberAt(index));
		}
	}
}
