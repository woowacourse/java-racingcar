package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private final static int NAME_LENGTH_MIN = 0;
    private final static int NAME_LENGTH_MAX = 5;
    private static final String SPLIT_DELIM = ",";
    public static final String ERROR_NAME_LENGTH = "[ERROR] 이름은 1자 이상, 5자 이하여야 합니다";
    public static final String ERROR_ONLY_NUMBER = "[ERROR] 시도 회수는 숫자만 입력 가능합니다";
    public static final String ERROR_DUPLICATE = "[ERROR] 중복된 이름이 존재합니다";

    public static void carNameValidation(final String input) {
        checkIsBlank(input);
        List<String> names = Arrays.asList(input.split(SPLIT_DELIM, -1));

        checkDuplicate(names);
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private static void checkDuplicate(final List<String> names) {
        Set<String> set = new HashSet<>(names);

        if (set.size() != names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private static void checkNameLength(final String name) {
        if (name.length() == NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public static void tryNumValidation(final String tryValue) {
        checkIsBlank(tryValue);
        for (char num : tryValue.toCharArray()) {
            checkCharIsNum(num);
        }
    }

    private static void checkCharIsNum(final char num) {
        if (!Character.isDigit(num)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }
}
