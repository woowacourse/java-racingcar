package racingcar.domain;

public class CarName {

    private static final int MIN_LENGTH_OF_NAME = 1;
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final String EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 입력되지 않았습니다.";
    private static final String MORE_THAN_ONE_LETTER = "[ERROR] 1글자 미만의 자동차 이름은 허용되지 않습니다.";
    private static final String LESS_THAN_FIVE_LETTER = "[ERROR] 5글자 초과의 자동차 이름은 허용되지 않습니다.";
    private static final String NO_SPACE = "[ERROR] 공백을 포함하는 자동차 이름은 허용되지 않습니다.";

    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateCarName(String name) {
        validateEmpty(name);
        validateSpace(name);
        validateLength(name);
    }

    private void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private void validateSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NO_SPACE);
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(MORE_THAN_ONE_LETTER);
        }

        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(LESS_THAN_FIVE_LETTER);
        }
    }

}
