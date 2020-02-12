package racing.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
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
			.ints(0, 9)
			.findFirst()
			.orElse(0);
	}

	public void goForward(int number) {
		if (number >= 4) {
			position++;
		}
	}

	public boolean isWinner(int winnersPosition) {
		return this.position == winnersPosition;
	}

	private String printPosition() {
		return IntStream.range(0, position)
			.mapToObj(x -> "-")
			.collect(Collectors.joining(""));
	}

	@Override
	public String toString() {
		return this.name + " : " + printPosition();
	}
}
