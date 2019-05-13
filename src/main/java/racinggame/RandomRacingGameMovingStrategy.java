package racinggame;

public class RandomRacingGameMovingStrategy implements RacingGameMovingStrategy {
	private final int randomMin;
	private final int randomMax;
	private final int moveBound;

	public RandomRacingGameMovingStrategy(int randomMin, int randomMax, int moveBound) {
		this.randomMin = randomMin;
		this.randomMax = randomMax;
		this.moveBound = moveBound;
	}

	private int generateRandomNumber() {
		return (int) (Math.random() * (randomMax + 1) + randomMin);
	}

	@Override
	public boolean movable() {
		return generateRandomNumber() >= moveBound;
	}
}
