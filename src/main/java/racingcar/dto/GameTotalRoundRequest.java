package racingcar.dto;

public class GameTotalRoundRequest {
	private final int gameTotalRound;

	public static GameTotalRoundRequest from(final int gameTotalRound) {
		return new GameTotalRoundRequest(gameTotalRound);
	}

	private GameTotalRoundRequest(final int gameTotalRound) {
		this.gameTotalRound = gameTotalRound;
	}

	public int getGameTotalRound() {
		return gameTotalRound;
	}
}
