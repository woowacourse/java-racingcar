package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

public class Car {
	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 5;
	public static final int MOVABLE_NUMBER_THRESHOLD = 4;

	private final String name;
	private int position;

	public Car(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return this.name;
	}

	public void move(int randomNumber) {
		if (randomNumber >= MOVABLE_NUMBER_THRESHOLD) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}
}
