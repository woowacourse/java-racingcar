package racingcar.controller;

import java.util.Random;

import racingcar.util.IntegerConst;

public class CarListController {
	private int generateRandNum() {
		Random random = new Random();
		return random.nextInt(IntegerConst.RANDOM_UPPER_BOUND.getValue());
	}
}
