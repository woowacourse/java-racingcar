package racingcar.validator;

import java.util.Arrays;

public class InputValidator {
    public static void isOnlyNumber(String round) {
        for (char c : round.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Round must be integer");
            }
        }
    }
}
