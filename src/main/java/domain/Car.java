package domain;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "자동차의 이름은 1 ~ 5 글자여야 합니다";

    private final String name;

    public Car(String input) {
        validateName(input);
        this.name = input;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
    }
}
