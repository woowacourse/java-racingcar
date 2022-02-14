package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NameValidator {
    public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다.";
    public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
    public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";
    public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";

    private static final int NAME_LENGTH_LIMIT = 5;

    public static void validateName(String names) {
        String[] splitName = StringSeparator.splitAndTrim(names);
        for (String name : splitName) {
            checkEmptyName(name);
            checkLongName(name);
        }
        checkOnlyName(splitName);
        checkDuplicateName(splitName);
    }

    private static void checkEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private static void checkOnlyName(String[] names) {
        if (names.length == 1) {
            throw new IllegalArgumentException(ERROR_ONLY_NAME);
        }
    }

    private static void checkLongName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_LONG_NAME);
        }
    }

    private static void checkDuplicateName(String[] names) {
        Set<String> hashNames = new HashSet<>(Arrays.asList(names));
        if (hashNames.size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

}
