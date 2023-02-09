package racingcar.domain;

public class CarMovement {
	private static final int STOP_MIN_NUMBER = 0;
	private static final int STOP_MAX_NUMBER = 3;
	private static final int MOVE_FORWARD_MIN_NUMBER = 4;
	private static final int MOVE_FORWARD_MAX_NUMBER = 9;

	private final NumberGenerator numberGenerator;

	public CarMovement(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public boolean isCarMoveForward() {
		int number = numberGenerator.generateNumber();
		if (isStop(number)) {
			return false;
		}
		if (isForward(number)) {
			return true;
		}
		return false;
	}

	private boolean isForward(int number) {
		return (number >= MOVE_FORWARD_MIN_NUMBER && number <= MOVE_FORWARD_MAX_NUMBER);
	}

	private boolean isStop(int number) {
		return (number >= STOP_MIN_NUMBER && number <= STOP_MAX_NUMBER);
	}
}
