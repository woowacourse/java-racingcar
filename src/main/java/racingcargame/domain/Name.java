package racingcargame.domain;

import java.util.HashSet;
import java.util.Set;

public class Name {
    private static final Set<String> CAR_NAMES = new HashSet<>();
    private static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK = "";

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
            System.out.println("중복된 이름을 가지고 있습니다.");
            throw new RuntimeException();
        }
    }

    private void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            System.out.println("길이 최대치를 초과하는 이름을 가지고 있습니다.");
            throw new RuntimeException();
        }
    }

    private void checkBlankInput(String name) {
        if (name.isEmpty()) {
            System.out.println("공백 이름을 가지고 있습니다.");
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
        return anotherName == this.name;
    }
}
