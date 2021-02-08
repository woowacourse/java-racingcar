package racingcar.domain.car;

public class Name {

    private static final String BLANK = " ";
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateNull(name);
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateNull(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateBlank(final String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return name;
    }

}
