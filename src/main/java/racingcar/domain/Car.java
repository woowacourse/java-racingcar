package racingcar.domain;

public class Car {
	private static final int MIN_MOVE_NUMBER = 4;
	private final Name name;
	private final Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void move(int number) {
		if (canMove(number)) {
			position.increase();
		}
	}

	private boolean canMove(int number) {
		return number >= MIN_MOVE_NUMBER;
	}

	public int getPosition() {
		return position.getValue();
	}

	public String getName() {
		return name.getValue();
	}
}
