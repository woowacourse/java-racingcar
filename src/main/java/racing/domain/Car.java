package racing.domain;

import static racing.view.OutputView.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
	public static final int MAX_LENGTH = 5;
	public static final int MIN_LENGTH = 1;
	private static final int FORWARD_PIVOT = 4;

	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void goForward(int number) {
		if (number >= FORWARD_PIVOT) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
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

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}
