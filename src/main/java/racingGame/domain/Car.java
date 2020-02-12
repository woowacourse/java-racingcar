package racingGame.domain;

import java.util.Objects;

public class Car {
	private static final int MOVE_BOUND = 4;
	private static final int INIT_POSITION = 0;

	private final Name name;
	private int position;

	public Car(Name name) {
		this.position = INIT_POSITION;
		this.name = name;
	}

	public void move(final int randomNumber) {
		if (isMove(randomNumber)) {
			this.position++;
		}
	}

	private boolean isMove(final int randomNumber) {
		return randomNumber >= MOVE_BOUND;
	}

	public boolean isWinnerPosition(final int winnerPosition) {
		return this.position == winnerPosition;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
