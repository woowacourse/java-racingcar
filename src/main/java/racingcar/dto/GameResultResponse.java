package racingcar.dto;

import java.util.List;

public class GameResultResponse {
	private final List<String> winnerNames;

	public static GameResultResponse from(List<String> winnerNames) {
		return new GameResultResponse(winnerNames);
	}

	private GameResultResponse(List<String> winnerNames) {
		this.winnerNames = winnerNames;
	}

	public List<String> getWinnerNames() {
		return winnerNames;
	}
}
