package racingcar.utils;

import java.util.Arrays;

public class Validator {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_CAR_NAME_QUANTITY = 2;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 50;

    public static void checkCarNames(String nameString) {
        checkNameStringFormat(nameString);
        checkEachName(nameString);
    }

    public static void checkEachName(String nameString) {
        String[] names = nameString.split(DELIMITER);

        for (String name : names) {
            checkLength(name);
        }
    }

    private static void checkLength(String name) {
        checkMinimumCarNameLength(name);
        checkMaximumCarNameLength(name);
    }

    private static void checkMinimumCarNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상이여야 합니다.");
        }
    }

    private static void checkMaximumCarNameLength(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 5글자 이하여야 합니다.");
        }
    }

    public static void checkNameStringFormat(String nameString) {
        checkBlankOrNull(nameString);
        checkInvalidNameString(nameString);
        checkDuplicateName(nameString);
        checkMinimumCarNameQuantity(nameString);
    }

    private static void checkInvalidNameString(String nameString) {
        if (isEmpty(nameString.split(DELIMITER))) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }

    private static void checkMinimumCarNameQuantity(String nameString) {
        if (hasMinimumCarName(nameString)) {
            throw new IllegalArgumentException("최소 자동차 수는 두 개 이상이어야 합니다.");
        }
    }

    private static void checkDuplicateName(String nameString) {
        if (hasDuplicateName(nameString)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static void checkBlankOrNull(String nameString) {
        if (isBlankOrNull(nameString)) {
            throw new IllegalArgumentException("입력값은 1글자 이상이여야 합니다");
        }
    }

    private static boolean isBlankOrNull(String nameString) {
        return nameString == null || nameString.isEmpty();
    }

    private static boolean hasMinimumCarName(String nameString) {
        return nameString.split(DELIMITER).length < MINIMUM_CAR_NAME_QUANTITY;
    }

    private static boolean hasDuplicateName(String nameString) {
        long origin = Arrays.stream(nameString.split(DELIMITER))
                .count();

        long distinct = Arrays.stream(nameString.split(DELIMITER))
                .distinct()
                .count();

        return origin != distinct;
    }

    private static boolean isEmpty(String[] array) {
        return array.length <= 0;
    }

    public static void checkCount(String countString) {
        try {
            int count = Integer.parseInt(countString);
            checkMinimumCount(count);
            checkMaximumCount(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 횟수는 숫자여야 합니다.");
        }
    }

    private static void checkMaximumCount(int count) {
        if (count >= MAXIMUM_COUNT) {
            throw new IllegalArgumentException("입력횟수는 50 이하의 정수여야 합니다.");

        }
    }

    private static void checkMinimumCount(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException("입력횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
