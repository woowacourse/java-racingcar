package racingcargame.domain;

import java.util.HashSet;
import java.util.Set;

public class Name {
    private static final Set<String> CAR_NAMES = new HashSet<>();

    public String getName() {
        return name;
    }

    private static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK = "";

    private String name;

    public Name(String name) {
        isDuplicatedNames(name);
        addName(name);
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        isExceededMaxLength(name);
        checkBlankInput(name);
    }

    private void addName(String name) {
        CAR_NAMES.add(name);
    }

    private void isDuplicatedNames(String input) {
        if (CAR_NAMES.contains(input)) {
            throw new RuntimeException("중복된 이름을 가지고 있습니다.");
        }
    }

    private void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException("길이 최대치를 초과하는 이름을 가지고 있습니다.");
        }
    }

    private void checkBlankInput(String name) {
        if (BLANK.equals(name)) {
            throw new RuntimeException("공백 이름을 가지고 있습니다.");
        }
    }
}
