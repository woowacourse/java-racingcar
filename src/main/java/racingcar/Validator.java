package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static int MAX_COUNT = 5;
    private static String ERROR_NAME_HAS_BLANK = "[ERROR] 이름에 공백이 존재합니다.";
    private static String ERROR_CAR_COUNT = "[ERROR] 자동차는 5대 이하이어야 합니다.";
    private static String ERROR_NAME_LENGTH = "[ERROR] 이름은 5자 이하이어야 합니다.";
    private static String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.";

    public static void validateBlank(String names) {
        for (int i = 0; i < names.length(); i++) {
            checkBlank(names, i);
        }
    }

    private static void checkBlank(String names, int i) {
        if (Character.isWhitespace(names.charAt(i))) {
            throw new IllegalArgumentException(ERROR_NAME_HAS_BLANK);
        }
    }

    public static void validateCarCount(String[] names) {
        if (names.length > MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    public static void validateNameLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public static void validateDuplicateName(String[] names) {
        Set<String> tempNameSet = new HashSet<>();
        for (String name : names) {
            tempNameSet.add(name);
        }

        if (tempNameSet.size() < names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

}
