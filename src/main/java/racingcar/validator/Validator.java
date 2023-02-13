package racingcar.validator;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름은 5자이하만 가능합니다.";
    private static final String NAME_DUPLICATE_EXCEPTION_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String TRYCOUNT_NUMERIC_EXCEPTION_MESSAGE = "시도할 횟수는 자연수만 가능합니다.";

    public void validateNames(List<String> names) {
        List<String> validNames = new ArrayList<>();
        for (String name : names) {
            checkNameLength(name);
            checkNameDuplicate(name, validNames);
            validNames.add(name);
        }
    }

    private void checkNameLength(String name) {
        int length = name.length();
        if (NAME_MIN_LENGTH <= length && length <= NAME_MAX_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    private void checkNameDuplicate(String name, List<String> validNames) {
        if (!validNames.contains(name)) {
            return;
        }
        throw new IllegalArgumentException(NAME_DUPLICATE_EXCEPTION_MESSAGE);
    }

    public void validateTryCount(String tryCount) {
        checkTryCountNumeric(tryCount);
    }

    private void checkTryCountNumeric(String tryCount) {
        if (tryCount != null && tryCount.matches("[0-9]+") && !tryCount.equals("0")) {
            return;
        }
        throw new IllegalArgumentException(TRYCOUNT_NUMERIC_EXCEPTION_MESSAGE);
    }
}
