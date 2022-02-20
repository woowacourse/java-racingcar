package racingcar.domain;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String ERROR_EMPTY = "이름 입력은 필수입니다.";
    private static final String ERROR_HAS_BLANK = "이름에 공백이 존재합니다.";
    private static final String ERROR_LENGTH = "이름은 5자 이하이어야 합니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNoName(name);
        validateBlank(name);
        validateNameLength(name);
    }

    private void validateNoName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    private void validateBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_HAS_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
