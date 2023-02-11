package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static final String NON_NUMBER_ERROR = "숫자만 입력 가능합니다.";
    public static final String EXCEEDED_CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";
    public static final String NUMBER_OF_TIME_ERROR = "1 이상만 가능합니다.";
    public static final String EXISTS_DUPLICATE_CAR_NAME_ERROR = "자동차명은 중복되어선 안됩니다.";

    public static final int LENGTH_LOWER_BOUND = 1;
    public static final int LENGTH_UPPER_BOUND = 5;
    public static final int NUMBER_OF_TIME_LOWER_BOUND = 0;
    public static final int NUMBER_OF_TIME_UPPER_BOUND = 101;

    public static void carNames(List<String> carNames) {
        exceededCarNameLength(carNames);
        existDuplicateCarName(carNames);
    }

    public static void numberOfTimes(String input) {
        nonNumber(input);
        int number = Integer.parseInt(input);

        if (number <= NUMBER_OF_TIME_LOWER_BOUND || NUMBER_OF_TIME_UPPER_BOUND <= number) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_ERROR);
        }
    }

    private static void exceededCarNameLength(List<String> carNames) {
        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> LENGTH_LOWER_BOUND <= carName.length() && carName.length() <= LENGTH_UPPER_BOUND);
    }

    private static void existDuplicateCarName(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(EXISTS_DUPLICATE_CAR_NAME_ERROR);
        }
    }

    private static void nonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR);
        }
    }
}
