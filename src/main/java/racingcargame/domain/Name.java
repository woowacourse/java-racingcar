package racingcargame.domain;

import java.util.HashSet;
import java.util.Set;

public class Name {
    // TODO : 에러 발생시 set 초기화 과정 필요하다.
    private static final Set<String> CAR_NAMES = new HashSet<>();

    private static final int NAME_MAX_LENGTH = 5;
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름을 가지고 있습니다.";
    private static final String LENGTH_LIMIT_EXCEED_ERROR_MESSAGE = "길이 최대치를 초과하는 이름을 가지고 있습니다.";
    private static final String SPACE_ERROR_MESSAGE = "공백 이름을 가지고 있습니다.";

    private String name;

    public Name(String name) {
        name = name.trim();
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
            System.out.println(DUPLICATE_NAME_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    private void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            System.out.println(LENGTH_LIMIT_EXCEED_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }

    private void checkBlankInput(String name) {
        if (name.isEmpty()) {
            System.out.println(SPACE_ERROR_MESSAGE);
            throw new RuntimeException();
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
