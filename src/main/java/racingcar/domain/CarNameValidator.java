package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
    public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";


    public static void validateCarNames(String[] splitCarNames) {
        checkOnlyName(splitCarNames);
        checkDuplicateName(splitCarNames);
    }

    private static void checkOnlyName(String[] names) {
        if (names.length == 1) {
            throw new IllegalArgumentException(ERROR_ONLY_NAME);
        }
    }

    private static void checkDuplicateName(String[] names) {
        Set<String> hashNames = new HashSet<>(Arrays.asList(names));
        if (hashNames.size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

}
