package racinggame;

public class SelectableRacingGameMovingStrategy implements RacingGameMovingStrategy {
	private final int moveBound;
	private final int number;

	public SelectableRacingGameMovingStrategy(int number, int moveBound) {
		this.number = number;
		this.moveBound = moveBound;
	}

	@Override
	public boolean movable() {
		return number >= moveBound;
	}
}