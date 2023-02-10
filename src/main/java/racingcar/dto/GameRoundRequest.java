package racingcar.dto;

public class GameRoundRequest {
	private final int totalGameRound;

	public static GameRoundRequest from(final int totalGameRound) {
		return new GameRoundRequest(totalGameRound);
	}

	private GameRoundRequest(final int totalGameRound) {
		this.totalGameRound = totalGameRound;
	}

	public int getRound() {
		return totalGameRound;
	}
}
