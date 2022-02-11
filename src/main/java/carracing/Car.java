package carracing;

import static carracing.view.messages.ExceptionMessage.*;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		if (name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return this.name;
	}

	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return name + " : " + "-".repeat(this.position);
	}
}
