package validation;

import static constant.Numbers.MAX_CAR_LENGTH;
import static constant.Numbers.MAX_ROUND;
import static constant.Numbers.MIN_CAR_LENGTH;
import static constant.Numbers.MIN_ROUND;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String NAME_RULE = "^[a-zA-Z]{1,5}$";

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            validateNameRules(name);
        }
        validateNameDuplication(names);
        validateCarAmount(names);
    }

    public static void validateRound(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException("1-100로 시도 횟수를 적어주세요.");
        }
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
