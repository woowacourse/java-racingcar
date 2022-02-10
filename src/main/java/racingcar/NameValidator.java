package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NameValidator {
    public static void validateNames(String names) {
        String[] splitName = names.split(",");
        for (String name : splitName) {
            checkEmptyName(name);
            checkNameLength(name);
        }
        checkOneName(splitName);
        checkDuplicateName(splitName);
    }

    private static void checkEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 이름이 있습니다.");
        }
    }

    private static void checkOneName(String[] names) {
        if (names.length == 1) {
            throw new IllegalArgumentException("[ERROR] 이름을 2개 이상 입력해주세요.");
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름을 5자 이하로 등록해주세요");
        }
    }

    private static void checkDuplicateName(String[] splitName) {
        Set<String> hashNames = new HashSet<>(Arrays.asList(splitName));
        if (hashNames.size() != splitName.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

}
