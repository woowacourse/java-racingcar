package racingcar.util;

import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateNullName(final String carNames) {
        if(carNames == null) {
            throw new IllegalArgumentException("자동차 이름 목록은 null일 수 없습니다.");
        }
    }

    public static void validateCarNames(final List<String> carNames) {
        for(String carName: carNames) {
            validateCarNamesFormat(carName);
        }
        validateDuplicatedNames(carNames);
    }

    private static void validateCarNamesFormat(final String carName) {
        if (carName.isBlank() || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private static void validateDuplicatedNames(final List<String> carNames) {
        final Set<String> uniqueNames = Set.copyOf(carNames);
        if(uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static int validateInteger(final String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 정수여야 합니다.");
        }
    }

    public static void validateTryCount(final int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도할 회수는 양의 정수여야 합니다.");
        }
    }
}
