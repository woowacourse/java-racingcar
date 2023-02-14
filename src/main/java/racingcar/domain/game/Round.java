package racingcar.domain.game;

public class Round {
	private final int value;

	public Round(int value) {
		this.value = value;
	}

	public Round nextRound() {
		return new Round(value + 1);
	}

	public boolean isSame(Round round) {
		return this.value == round.value;
	}
}
