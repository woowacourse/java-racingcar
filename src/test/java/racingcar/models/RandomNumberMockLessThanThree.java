package racingcar.models;

import java.util.Random;

import racingcar.utils.RandomNumber;

public class RandomNumberMockLessThanThree extends RandomNumber {
	private static final int MAX_EXCLUSIVE = 3;

	@Override
	public int getRandomNumber() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(MAX_EXCLUSIVE) + 1;
	}
}
