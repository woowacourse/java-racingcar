package racingcar.domain;

import static racingcar.utils.RandomGenerator.getRandomNumberInRange;

public class Car {

    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_GO_FORWARD_RANGE = 4;
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String PROGRESS_BAR = "-";
    private static final int MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String ERROR_NO_NAME = "[ERROR] 이름 입력은 필수입니다.";
    private static final String ERROR_NAME_HAS_BLANK = "[ERROR] 이름에 공백이 존재합니다.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 이름은 5자 이하이어야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        position = 0;
    }

    private void validateName(String name) {
        validateNoName(name);
        validateBlank(name);
        validateNameLength(name);
    }

    private void validateNoName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NO_NAME);
        }
    }

    private void validateBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_NAME_HAS_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        if (isCarGoForward()) {
            position++;
        }
    }

    private boolean isCarGoForward() {
        return getRandomNumberInRange(MAX_RANDOM_RANGE) >= MIN_GO_FORWARD_RANGE;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car("
                + "name = " + name
                + ", position = " + position
                + ")";
    }
}
