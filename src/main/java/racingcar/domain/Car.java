package racingcar.domain;

public class Car {
	private static final int CAR_MOVE_CONDITION = 4;

	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
	}

	public void moveOrNot(int randomNumber) {
		if (randomNumber >= CAR_MOVE_CONDITION) {
			++position;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public boolean matchPosition(int maxDistance) {
		return (position == maxDistance);
	}

	public int comparePosition(int distance) {
		return ((this.position < distance) ? distance : this.position);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
