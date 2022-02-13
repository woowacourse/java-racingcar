package racingcar.domain.strategy;

public class MovingStrategyFactory {

	private static final MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
	private static final MovingStrategy fixedMovingStrategy = new FixedMovingStrategy();

	public static MovingStrategy randomMovingCar() {
		return randomMovingStrategy;
	}

	public static MovingStrategy fixedMovingCar() {
		return fixedMovingStrategy;
	}
}
