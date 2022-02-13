package racingcar.domain.strategy;

public class FixedMovingStrategy implements MovingStrategy {

	private boolean isMove() {
		return true;
	}

	@Override
	public boolean movable() {
		return isMove();
	}
}
