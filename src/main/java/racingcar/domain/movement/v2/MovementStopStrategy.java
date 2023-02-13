package racingcar.domain.movement.v2;

public class MovementStopStrategy implements MovementStrategy {
	private static final int MOVE_STOP_DISTANCE = 0;
	@Override
	public int getDistance() {
		return MOVE_STOP_DISTANCE;
	}
}
