package racingcar.domain;

public class Car implements Comparable<Car> {
	private static final String STEP = "-";
	private static final String FORMAT = "%s : %s";
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private void move() {
		position++;
	}

	public void drive(boolean directing) {
		if (directing) {
			move();
		}
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		StringBuilder positions = new StringBuilder();
		for (int i = 0; i < position; i++) {
			positions.append(STEP);
		}
		return String.format(FORMAT, name, positions);
	}

	@Override
	public int compareTo(Car car) {
		return this.position - car.position;
	}
}
