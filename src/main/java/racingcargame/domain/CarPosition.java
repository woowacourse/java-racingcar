package racingcargame.domain;

class CarPosition {

	private static final int DEFAULT_POSITION = 0;
	private static final int MOVE_UNIT = 1;

	private int position;

	CarPosition() {
		this.position = DEFAULT_POSITION;
	}

	CarPosition(int position) {
		this.position = position;
	}

	void increase() {
		this.position += MOVE_UNIT;
	}

	int getPosition() {
		return position;
	}
}
