package racingcar.dto.request;

import racingcar.exception.ErrorMessage;
import racingcar.exception.ErrorMessageDetail;
import racingcar.exception.InvalidInputException;

public record RaceCountRequest(String input) {
    private static final int MAX_RACE_COUNT = 100;
    private static final int MIN_RACE_COUNT = 1;

    public int toInt() {
        final int count = validateInt();
        validateRaceCountRange(count);
        return count;
    }

    private int validateInt() {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    private void validateRaceCountRange(final int count) {
        if (count > MAX_RACE_COUNT || MIN_RACE_COUNT > count) {
            String errorDetail = String.format(ErrorMessageDetail.RACE_COUNT_RANGE, MIN_RACE_COUNT, MAX_RACE_COUNT);
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH, errorDetail);
        }
    }
}
