package racingcargame.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Name {

    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int NAME_UPPER_LIMIT = 5;

    private final String name;

    Name(String name) {
        validateNotNull(name);
        validateLength(name);
        validateNoBlank(name);
        this.name = name;
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private void validateNoBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에는 띄어쓰기가 포함될 수 없습니다.");
        }
    }

    public static List<Name> createNameObjects(String userInputName) {
        List<Name> nameList = new ArrayList<>();
        String[] names = userInputName.split(COMMA);
        if (names.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        for (String name : names) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    String getName() {
        return name;
    }
}
