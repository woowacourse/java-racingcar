package validation;

import java.util.List;

public class Validator {

    public static final String NAME_RULE = "^[a-zA-Z]{1,5}$";

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            validateNameRules(name);
        }
//        validateNameDuplication();
    }

    private static void validateNameRules(String name) {
        if (!name.matches(NAME_RULE)) {
            throw new IllegalArgumentException("1~5자의 알파벳만 입력 가능합니다.");
        }
    }
}
