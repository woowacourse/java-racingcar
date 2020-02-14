package racingcar.domain;

public class Name {
    static final int MAXIMUM_NAME = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME + "자 이하여야 합니다.");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
