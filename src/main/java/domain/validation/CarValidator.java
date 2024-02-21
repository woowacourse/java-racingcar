package domain.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {
    private CarValidator() {
    }

    private static final int MIN_CAR_LENGTH = 1;
    private static final int MAX_CAR_LENGTH = 100;
    private static final String NAME_RULE = "^[a-zA-Z]{1,5}$";

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            validateNameRules(name);
        }
        validateNameDuplication(names);
        validateCarAmount(names);
    }


    private static void validateNameRules(String name) {
        if (!name.matches(NAME_RULE)) {
            throw new IllegalArgumentException("1~5자의 알파벳만 입력 가능합니다.");
        }
    }

    private static void validateNameDuplication(List<String> names) {
        Set<String> nonDuplicatedNames = new HashSet<>(names);
        if (nonDuplicatedNames.size() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static void validateCarAmount(List<String> names) {
        int namesSize = names.size();
        if (namesSize < MIN_CAR_LENGTH || namesSize > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException("차량은 1~100대만 허용합니다.");
        }
    }
}
