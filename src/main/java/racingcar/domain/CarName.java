package racingcar.domain;

public class CarName {
    public static final String ERROR_MESSAGE_OF_INVALID_INPUT = "옳지 않은 입력입니다.";
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;
    private static final String ERROR_MESSAGE_OF_NAME_LENGTH = "이름은 0~5 이내입니다.";
    private static final String SPACE = " ";

    private final String name;

    public CarName(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_INVALID_INPUT);
        }
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
