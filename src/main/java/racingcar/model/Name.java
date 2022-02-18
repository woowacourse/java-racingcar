package racingcar.model;

public class Name {
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final int MAXIMUM_NAME_LENGTH = 10;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;

    public Name(String name) {
        this.name = removeBlank(name);
        validateBlank(name);
        validateNameLength(name);
    }

    private String removeBlank(String name) {
        return name.replace(SPACE, BLANK);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        boolean isValidLength = name.length() <= MAXIMUM_NAME_LENGTH;
        if (!isValidLength) {
            throw new IllegalArgumentException("이름은 10자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
