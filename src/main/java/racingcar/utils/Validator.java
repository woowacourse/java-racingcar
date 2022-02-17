package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;
    private static final int MIN_NUMBER = 0;
    private static final String ERROR_NAME_HAS_BLANK = "[ERROR] 이름에 공백이 존재합니다.";
    private static final String ERROR_NO_NAME = "[ERROR] 이름 입력은 필수입니다.";
    private static final String ERROR_CAR_COUNT = "[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 이름은 5자 이하이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.";
    private static final String ERROR_NUMBER_OVER_ONE = "[ERROR] 횟수는 1 이상이어야 합니다.";

    public static void validateEachCarName(String[] names) {
        validateNoNames(names);
        validateCarCount(names);
        validateNameLength(names);
        validateDuplicateName(names);
    }

    public static void validateBlank(String names) {
        String nameNoSpace = names.replace(" ", "");
        if (!nameNoSpace.equals(names)) {
            throw new IllegalArgumentException(ERROR_NAME_HAS_BLANK);
        }
    }

    private static void validateNoNames(String[] names) {
        for (String name : names) {
            checkNoName(name);
        }
    }

    private static void checkNoName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_NO_NAME);
        }
    }

    private static void validateCarCount(String[] names) {
        if (names.length > MAX_COUNT || names.length < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private static void validateNameLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private static void validateDuplicateName(String[] names) {
        Set<String> tempNameSet = new HashSet<>(Arrays.asList(names));

        if (tempNameSet.size() < names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public static void checkPositiveNumber(int parseInt) {
        if (parseInt <= MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_OVER_ONE);
        }
    }

}
