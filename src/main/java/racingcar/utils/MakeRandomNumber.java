package racingcar.utils;

import racingcar.domain.RandomNo;

import java.util.Random;

public class MakeRandomNumber {
	private MakeRandomNumber(){}

	private static final int maxRange = 10;

	public static RandomNo generateRandomIntIntRange() {
		Random r = new Random();
		return new RandomNo(r.nextInt(maxRange));
	}
}
