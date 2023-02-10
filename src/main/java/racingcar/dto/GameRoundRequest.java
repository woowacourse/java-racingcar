package racingcar.dto;

public class GameRoundRequest {
	private final int totalGameRound;

	public static GameRoundRequest from(int totalGameRound) {
		return new GameRoundRequest(totalGameRound);
	}

	private GameRoundRequest(int totalGameRound) {
		this.totalGameRound = totalGameRound;
	}

	public int getRound() {
		return totalGameRound;
	}
}
