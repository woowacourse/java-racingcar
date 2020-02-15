package racingcar.domain;

public class Name {
    static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
