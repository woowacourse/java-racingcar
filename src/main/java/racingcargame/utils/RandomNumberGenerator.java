package racingcargame.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
	private static final int MAX_NUMBER = 10;
	private static final int MIN_NUMBER = 0;

	private static List<Integer> numbers = IntStream.range(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());

	private RandomNumberGenerator() {
	}

	public static int pickRandomNumber() {
		Collections.shuffle(numbers);
		return numbers.get(0);
	}
}
