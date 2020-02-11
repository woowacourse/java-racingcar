package racingGame.utils;

public class MovementStrategy {
	private static final int MOVEMENT_STRATEGY_BOUND = 4;

	public static boolean isMovementStrategy(final int randomNumber) {
		return randomNumber >= MOVEMENT_STRATEGY_BOUND;
	}
}
