package racingcargame.domain.car;

class CarPosition {
	private static final int DEFAULT_POSITION = 0;
	private static final int MOVE_UNIT = 1;

	private int position;

	CarPosition() {
		this.position = DEFAULT_POSITION;
	}

	void increase() {
		this.position += MOVE_UNIT;
	}

	int getPosition() {
		return position;
	}
}
