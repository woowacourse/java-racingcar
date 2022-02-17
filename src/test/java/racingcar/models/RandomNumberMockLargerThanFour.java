package racingcar.models;

import java.util.Random;

import racingcar.utils.RandomNumber;

public class RandomNumberMockLargerThanFour extends RandomNumber {

	private static final int MAX_EXCLUSIVE = 6;

	@Override
	public int getRandomNumber() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(MAX_EXCLUSIVE) + 4;
	}
}
