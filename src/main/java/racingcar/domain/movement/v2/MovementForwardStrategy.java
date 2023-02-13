package racingcar.domain.movement.v2;

public class MovementForwardStrategy implements MovementStrategy {
	private static final int MOVE_FORWARD_DISTANCE = 1;

	@Override
	public int getDistance() {
		return MOVE_FORWARD_DISTANCE;
	}
}
