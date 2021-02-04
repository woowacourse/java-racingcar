package racingcar.domain;

public class Car {
    private static final String ERROR_NAME_NOT_PERMIT_NULL_MESSAGE = "[ERROR] 자동차 이름은 null을 허용하지 않습니다.";
    private static final String ERROR_NAME_HAS_NOT_SPECIAL_CHARACTER_MESSAGE = "[ERROR] 자동차 이름에 특수문자를 사용할 수 없습니다.";
    private static final String ERROR_NAME_NOT_PERMIT_EMPTY_MESSAGE = "[ERROR] 자동차 이름은 공백을 허용하지 않습니다.";
    private static final String ERROR_NAME_NOT_LONGER_THAN_NAME_LIMIT_MESSAGE = "[ERROR] 자동차 이름의 길이는 최대 5글자 입니다.";
    private static final int NAME_LENGTH_MAX_LIMIT = 5;


    private final String name;

    public Car(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateEmpty(name);
        validateLength(name);
        validateSpecialCharacters(name);
    }

    private void validateSpecialCharacters(String name) {
        for (char partOfName : name.toCharArray()) {
            validateSpecialCharacter(partOfName);
        }
    }

    private void validateSpecialCharacter(char partOfName) {
        if (Character.isLetterOrDigit(partOfName)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_NAME_HAS_NOT_SPECIAL_CHARACTER_MESSAGE);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_PERMIT_NULL_MESSAGE);
        }
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_PERMIT_EMPTY_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > NAME_LENGTH_MAX_LIMIT) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_LONGER_THAN_NAME_LIMIT_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
