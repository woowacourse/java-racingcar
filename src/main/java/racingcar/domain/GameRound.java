package racingcar.domain;

public class GameRound {
	private static final int GAME_ROUND_DEFAULT_ROUND = 0;
	private final int totalGameRound;
	private int currRound;

	public GameRound(final int totalGameRound) {
		this.totalGameRound = totalGameRound;
		this.currRound = GAME_ROUND_DEFAULT_ROUND;
	}

	public void increaseRound() {
		this.currRound++;
	}

	public boolean isEnd() {
		return this.currRound == this.totalGameRound;
	}
}
