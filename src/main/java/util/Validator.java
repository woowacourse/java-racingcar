package util;

import message.Constant;
import message.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void carNames(List<String> carNames) {
        carNameLength(carNames);
        existDuplicateValue(carNames);
    }

    public static void numberOfTimes(int number) {
        if (number <= Constant.NUMBER_OF_TIME_LOWER_BOUND || Constant.NUMBER_OF_TIME_UPPER_BOUND <= number) {
            throw new IllegalArgumentException(Error.NUMBER_OF_TIME_RANGE_ERROR);
        }
    }

    private static void carNameLength(List<String> carNames) {
        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException(Error.CAR_NAME_LENGTH_ERROR);
        }
    }

    private static boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> Constant.LENGTH_LOWER_BOUND <= carName.length() && carName.length() <= Constant.LENGTH_UPPER_BOUND);
    }

    private static void existDuplicateValue(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_CAR_NAME_ERROR);
        }
    }
}
