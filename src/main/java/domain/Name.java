package domain;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. ";
    public static final String BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE = "이름에 공백을 포함할 수 없습니다.";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateToContainBlank(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE + "입력값 : "  + name);
        }
    }

    private void validateToContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE + "입력값 : " + name);
        }
    }

    public String getName() {
        return name;
    }
}
