package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class CarNamesValidator {
    private static final String DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE = "중복된 차 이름이 존재합니다.";

    public static void validate(final List<String> names) {
        if (isDuplicateNames(names)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE);
        }
    }

    private static boolean isDuplicateNames(final List<String> names) {
        return new HashSet<>(names).size() != names.size();
    }
}
