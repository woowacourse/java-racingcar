package racingcargame.domain;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_LIMIT = 5;

    private String name;

    public Name(String name) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("빈 값을 입력하지 마세요.");
        }
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("5자 이내만 입력 가능합니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
