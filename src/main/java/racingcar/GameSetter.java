package racingcar;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameSetter {

    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private GameSetter() {
    }

    public static int setTrial(String input) {
        validateNumber(input);
        try {
            int trial = Integer.parseInt(input);
            return validateBound(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
    }

    private static void validateNumber(String input) {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static int validateBound(int trial) {
        if (trial < MIN_TRIAL) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
        return trial;
    }
}