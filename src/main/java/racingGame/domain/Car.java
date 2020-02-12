package racingGame.domain;

public class Car {
	private static final int MOVE_BOUND = 4;

	public boolean isMove(final int randomNumber) {
		return randomNumber >= MOVE_BOUND;
	}
}
