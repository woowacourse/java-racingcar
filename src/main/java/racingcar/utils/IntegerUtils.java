package racingcar.utils;

import static racingcar.domain.round.Round.NOT_MIN_NUMBER_ERROR_MESSAGE;

public class IntegerUtils {

    public static int parseInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_MIN_NUMBER_ERROR_MESSAGE);
        }
    }
}
