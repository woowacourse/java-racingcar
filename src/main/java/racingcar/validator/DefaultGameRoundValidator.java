package racingcar.validator;

import static racingcar.exception.ErrorMessages.*;

public class DefaultGameRoundValidator implements GameRoundValidator {
    @Override
    public void validateGameRoundInput(String inputGameRound) {
        validateBlank(inputGameRound);
        validateNotStartZero(inputGameRound);
        validateInteger(inputGameRound);
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
}
