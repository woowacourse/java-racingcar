package racingcar.dto;

import static racingcar.messsages.ExceptionMessage.*;

public class GameRoundRequest {
	private final int round;

	public static GameRoundRequest from(String gameRound) {
		return new GameRoundRequest(gameRound);
	}

	private GameRoundRequest(String gameRound) {
		validateBlank(gameRound);
		validateNotStartZero(gameRound);
		validateInteger(gameRound);
		round = Integer.parseInt(gameRound);
	}

	private void validateBlank(String gameRound) {
		if (gameRound.isBlank()) {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateInteger(String gameRound) {
		boolean isDigit = gameRound.chars().allMatch(Character::isDigit);
		if (!isDigit) {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_DIGIT_EXCEPTION.getMessage());
		}
	}

	private void validateNotStartZero(String gameRound) {
		if (gameRound.charAt(0) == '0') {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_ZERO_EXCEPTION.getMessage());
		}
	}

	public int getRound() {
		return round;
	}
}
