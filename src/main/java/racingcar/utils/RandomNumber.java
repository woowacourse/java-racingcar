package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

	private static final int MAX_EXCLUSIVE = 9;

	private RandomNumber() {}

	public static List<Integer> getRandomNumbers(final int size) {
		final List<Integer> randomNumbers = new ArrayList<>();
		for (int s = 0; s < size; s++) {
			randomNumbers.add(getRandomNumber());
		}
		return randomNumbers;
	}

	private static int getRandomNumber() {
		final Random random = new Random();
		return random.nextInt(MAX_EXCLUSIVE) + 1;
	}
}
