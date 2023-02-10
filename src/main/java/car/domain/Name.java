package car.domain;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_FORMAT = "이름은 %d글자 이상 %d글자 이하입니다";
    private static final String LENGTH_EXCEPTION_MESSAGE = String.format(LENGTH_EXCEPTION_FORMAT, MIN_LENGTH,
            MAX_LENGTH);

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void validateNameLength(String name) {
        if (name.length() < MIN_LENGTH || MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
