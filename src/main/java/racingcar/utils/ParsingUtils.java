package racingcar.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ParsingUtils {

    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;

    private static final String NUMBER_PATTERN = "[0-9]+";

    private ParsingUtils() {
    }

    public static Cars parseCarNames(final String input) {
        final String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        return new Cars(Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public static Integer parseTrial(final String input) {
        validateNumber(input);
        try {
            final Integer trial = Integer.parseInt(input);
            return validateBound(trial);
        } catch (NumberFormatException e) {
            // int　범위 밖의 입력의 경우 예외처리
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
    }

    private static void validateNumber(final String input) {
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static int validateBound(final Integer trial) {
        if (trial < MIN_TRIAL) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
        return trial;
    }
}