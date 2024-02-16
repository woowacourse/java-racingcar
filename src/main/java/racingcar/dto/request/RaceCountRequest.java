package racingcar.dto.request;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;
import racingcar.view.utils.InputUtils;

public record RaceCountRequest(String input) {
    public static final int MAX_RACE_COUNT = 100;
    public static final int MIN_RACE_COUNT = 1;

    public int toInt() {
        int count = InputUtils.parseToInt(input);
        validateRaceCountRange(count);
        return count;
    }

    private void validateRaceCountRange(final int count) {
        if (count > MAX_RACE_COUNT || MIN_RACE_COUNT > count) {
            throw new InvalidInputException(ErrorMessage.INVALID_RACE_COUNT_RANGE);
        }
    }
}
