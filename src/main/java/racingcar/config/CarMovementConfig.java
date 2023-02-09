package racingcar.config;

public enum CarMovementConfig {
	STOP_MIN_NUMBER(0),
	STOP_MAX_NUMBER(3),
	MOVE_FORWARD_MIN_NUMBER(4),
	MOVE_FORWARD_MAX_NUMBER(9);

	private final int number;

	CarMovementConfig(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
