package racingcar.dto;

import java.util.List;

public class GameResultResponse {
	private final List<String> winnerNames;

	public static GameResultResponse from(final List<String> winnerNames) {
		return new GameResultResponse(winnerNames);
	}

	private GameResultResponse(final List<String> winnerNames) {
		this.winnerNames = winnerNames;
	}

	public List<String> getWinnerNames() {
		return winnerNames;
	}
}
