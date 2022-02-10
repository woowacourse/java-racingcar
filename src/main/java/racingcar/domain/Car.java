package racingcar.domain;

public class Car {

	private final String name;
	private int position;

	private static final int INITIAL_POSITION = 0;
	private static final int STANDARD_OF_MOVING = 4;

	private Car(String name) {
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	private Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static Car of(String name) {
		return new Car(name);
	}

	public static Car of(String name, int position) {
		return new Car(name, position);
	}

	public void move(int randomNumber) {
		if (randomNumber >= STANDARD_OF_MOVING) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public CarDto toDto() {
		return new CarDto(this.name, this.position);
	}
}
