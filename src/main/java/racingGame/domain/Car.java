package racingGame.domain;

public class Car {
	private static final int MOVE_BOUND = 4;
	private static final int INIT_POSITION = 0;

	private int position;

	public Car() {
		this.position = INIT_POSITION;
	}

	public boolean isMove(final int randomNumber) {
		return randomNumber >= MOVE_BOUND;
	}

	public void move(final boolean carMove) {
		if (carMove) {
			this.position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
