package racingcar.dto;

import java.util.List;

public class GameWinnersResponse {
	private final List<String> winnerNames;

	public static GameWinnersResponse from(final List<String> winnerNames) {
		return new GameWinnersResponse(winnerNames);
	}

	private GameWinnersResponse(final List<String> winnerNames) {
		this.winnerNames = winnerNames;
	}

	public List<String> getWinnerNames() {
		return winnerNames;
	}
}
