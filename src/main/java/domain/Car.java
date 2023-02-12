package domain;

import java.util.Objects;

public class Car {
	public static final int MIN_BOUND = 1;
	public static final int MAX_BOUND = 5;
	public static final int THRESHOLD = 4;
	private static final String ONE_TO_FIVE = "이름은 1이상 5이하입니다.";
	private final String carName;
	private int distance = 0;

	public Car(String input) {
		String trimInput = trimAllBlank(input);
		validateNameLength(trimInput);
		this.carName = trimInput;
	}

	private String trimAllBlank(String input) {
		return input.replaceAll(" ", "");
	}

	private void validateNameLength(String input) {
		if (input.length() < MIN_BOUND || input.length() > MAX_BOUND) {
			throw new IllegalArgumentException(ONE_TO_FIVE);
		}
	}

	public void addDistance(int power) {
		if (power >= THRESHOLD) {
			distance++;
		}
	}

	public String getCarName() {
		return carName;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object ob) {
		String carName = "";
		if (ob instanceof String) {
			carName = (String)ob;
		}
		return Objects.equals(this.carName, carName);
	}
}
