package racingcargame.domain;

import java.util.HashSet;
import java.util.Set;

public class Name {
    private static final Set<String> CAR_NAMES = new HashSet<>();

    private static final int NAME_MAX_LENGTH = 5;
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름을 가지고 있습니다.";
    private static final String LENGTH_LIMIT_EXCEED_ERROR_MESSAGE = "RR길이 최대치를 초과하는 이름을 가지고 있습니다.";
    private static final String SPACE_ERROR_MESSAGE = "공백 혹은 null 이름을 가지고 있습니다.";

    private String name;

    public Name(String name) {
        checkBlankOrNullInput(name);
        name = name.trim();
        isDuplicatedNames(name);
        addName(name);
        isExceededMaxLength(name);
        this.name = name;
    }

    private void addName(String name) {
        CAR_NAMES.add(name);
    }

    private void isDuplicatedNames(String input) {
        if (CAR_NAMES.contains(input)) {
            CAR_NAMES.clear();
            System.out.println(DUPLICATE_NAME_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    private void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            CAR_NAMES.clear();
            System.out.println(LENGTH_LIMIT_EXCEED_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    private void checkBlankOrNullInput(String name) {
        if (name == null || name.isEmpty()) {
            CAR_NAMES.clear();
            System.out.println(SPACE_ERROR_MESSAGE);
            throw new NullPointerException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String anotherName = (String) obj;
        return anotherName.equals(this.name);
    }
}
