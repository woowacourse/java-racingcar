package racingcar.dto;

import static racingcar.exception.ErrorMessages.*;

public class GameRoundDTO {
	private final int round;

	public GameRoundDTO(String gameRound) {
		validateInteger(gameRound);
		validateNotStartZero(gameRound);
		round = Integer.parseInt(gameRound);
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
