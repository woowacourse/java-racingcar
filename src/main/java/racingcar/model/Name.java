package racingcar.model;

public class Name {
    private static final int NAME_LEN = 5;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > NAME_LEN) {
            throw new IllegalArgumentException("[Error] 자동차 이름은 5자 이하여야 합니다.\n");
        }
    }

    public String getName() {
        return name;
    }
}
