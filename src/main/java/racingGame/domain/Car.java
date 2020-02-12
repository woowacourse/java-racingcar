package racingGame.domain;

public class Car {
	private static final int MOVE_BOUND = 4;
	private static final int INIT_POSITION = 0;

	private int position;

	public Car() {
		this.position = INIT_POSITION;
	}

	public void move(final int randomNumber) {
		if (isMove(randomNumber)) {
			this.position++;
		}
	}

	private boolean isMove(final int randomNumber) {
		return randomNumber >= MOVE_BOUND;
	}

	public int getPosition() {
		return position;
	}
}
