package racingcar.domain.game;

public class GameRound {
	private static final int GAME_ROUND_DEFAULT_ROUND = 0;
	private final Round totalRound;
	private Round currRound;

	public GameRound(final int totalRound) {
		this.totalRound = new Round(totalRound);
		this.currRound = new Round(GAME_ROUND_DEFAULT_ROUND);
	}

	public void nextRound() {
		currRound = currRound.nextRound();
	}

	public boolean isEnd() {
		return totalRound.isSame(currRound);
	}
}
