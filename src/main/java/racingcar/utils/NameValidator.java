package racingcar.utils;

import java.util.List;

public class NameValidator {
    private static final String WRONG_NAME_MESSAGE = "빈 글자이거나 5글자를 초과하는 이름이 존재합니다.";
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void isValidateName(String carName) {
        if (isInvalidNameLength(carName.length()) || isNullOrBlankName(carName)) {
            throw new IllegalArgumentException(WRONG_NAME_MESSAGE);
        }
    }

    private static boolean isInvalidNameLength(int nameLength) {
        return nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH;
    }

    private static boolean isNullOrBlankName(String carName) {
        return carName == null || carName.isBlank();
    }

    public static void isDuplicatedNames(List<String> carNames) {
        if (isContainingDuplicatedName(carNames)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private static boolean isContainingDuplicatedName(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
