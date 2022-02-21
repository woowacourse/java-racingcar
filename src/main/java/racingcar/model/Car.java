package racingcar.model;

public class Car {
	private static final int BASE_POSITION = 0;
	private static final int MOVE_BOUND = 3;
	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = BASE_POSITION;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void movePosition(int number) {
		if (number > MOVE_BOUND) {
			++this.position;
		}
	}

	public Boolean isPositionAt(int targetPosition) {
		return this.position == targetPosition;
	}
}
