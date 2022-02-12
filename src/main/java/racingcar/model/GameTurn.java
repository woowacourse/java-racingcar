package racingcar.model;

public class GameTurn {
	private static final String GAME_TURN_NUMBER_ERROR_MESSAGE = "[Error] 양수를 입력하세요.";
	private static final String RANDOM_NUMBER_REGEX = "[1-9]\\d*";

	private int gameTurn;

	public GameTurn(String gameTurn) {
		checkGameTurnNumber(gameTurn);
		this.gameTurn = Integer.parseInt(gameTurn);
	}

	private void checkGameTurnNumber(String gameTurn) {
		if (!gameTurn.matches(RANDOM_NUMBER_REGEX)) {
			throw new IllegalArgumentException(GAME_TURN_NUMBER_ERROR_MESSAGE);
		}
	}

	public boolean isPositive() {
		return gameTurn > 0;
	}

	public void removeTurn() {
		gameTurn--;
	}
}
