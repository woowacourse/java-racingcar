package racing.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
	private static final int FORWARD_PIVOT = 4;
	private static final int RANDOM_MAX = 9;
	private static final int RANDOM_MIN = 0;
	private static final String POSITION_VIEWER = "-";
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int randomGenerate() {
		return ThreadLocalRandom.current()
			.ints(RANDOM_MIN, RANDOM_MAX)
			.findFirst()
			.orElse(RANDOM_MIN);
	}

	public void goForward(int number) {
		if (number >= FORWARD_PIVOT) {
			position++;
		}
	}

	public boolean isWinner(int winnersPosition) {
		return this.position == winnersPosition;
	}

	private String printPosition() {
		return IntStream.range(0, position)
			.mapToObj(x -> POSITION_VIEWER)
			.collect(Collectors.joining());
	}

	@Override
	public String toString() {
		return this.name + " : " + printPosition();
	}
}
