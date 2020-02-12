package racingcar.domain;

public class Car implements Comparable<Car> {
	public static final int MAXIMUM_LENGTH = 5;
	public static final int MOVING_NUMBER = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isInvalid(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	private boolean isInvalid(String name) {
		return name == null
			|| name.length() > MAXIMUM_LENGTH
			|| name.trim().isEmpty();
	}

	public void move(int random) {
		if (isMoving(random)) {
			position++;
		}
	}

	private boolean isMoving(int random) {
		return random >= MOVING_NUMBER;
	}

	public boolean isOnSamePosition(Car anotherCar) {
		return compareTo(anotherCar) == 0;
	}

	public String getCoWinnersName(Car anotherCar) {
		if (isOnSamePosition(anotherCar)) {
			return anotherCar.name;
		}
		return null;
	}

	@Override
	public int compareTo(Car anotherCar) {
		return anotherCar.position - position;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		sb.append("\n");
		return sb.toString();
	}
}
