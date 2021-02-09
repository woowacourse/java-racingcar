package racingcar.domain.input.racingtrytime.validator;

import racingcar.domain.input.racingtrytime.validator.exception.NotNaturalNumberRacingTimeException;

public class RacingTryTimeValidator {
    private static final String ERROR_MESSAGE = "경주 시도 횟수는 자연수여야 합니다.";
    private static final int MIN_NATURAL_NUMBER = 1;

    public void validate(String racingTryTime) {
        validateNaturalNumberRacingTime(racingTryTime);
    }

    private void validateNaturalNumberRacingTime(String racingTryTime) {
        int convertedRacingTryTime = validateIntegerRacingTime(racingTryTime);
        validateOneOrMoreRacingTime(convertedRacingTryTime);
    }

    private int validateIntegerRacingTime(String racingTryTime) {
        try {
            return Integer.parseInt(racingTryTime);
        } catch (Exception e) {
            throw new NotNaturalNumberRacingTimeException(ERROR_MESSAGE);
        }
    }

    private void validateOneOrMoreRacingTime(int integerConvertedRacingTime) {
        if (integerConvertedRacingTime < MIN_NATURAL_NUMBER) {
            throw new NotNaturalNumberRacingTimeException(ERROR_MESSAGE);
        }
    }
}
