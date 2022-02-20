package racingcar.model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Random {
	private static final int RANDOM_BOUND = 10;

	private final ThreadLocalRandom random = ThreadLocalRandom.current();

	public List<Integer> createNumbers(int size) {
		return IntStream.range(0, size)
			.mapToObj(i -> random.nextInt(RANDOM_BOUND))
			.collect(Collectors.toList());
	}
}
