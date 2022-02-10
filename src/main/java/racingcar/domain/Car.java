package racingcar.domain;

public class Car {

	private static final int INITIAL_POSITION = 0;
	private static final int STANDARD_OF_MOVING = 4;

	private final String name;
	private int position;

	private Car(String name) {
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	public static Car of(String name) {
		return new Car(name);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move(int randomNumber) {
		if (randomNumber >= STANDARD_OF_MOVING) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

}
