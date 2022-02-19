package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MINIMUM_MOVE = 4;
    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String SPACE = " ";

    private static final String NOT_ALLOW_MAXIMUM_LENGTH_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 5자 이하만 가능합니다.)";
    private static final String NOT_ALLOW_MINIMUM_LENGTH_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 1자 이상만 가능합니다.)";
    private static final String NOT_ALLOW_SPACE_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름에 공백 입력은 불가능합니다.)";

    private final String name;
    private int position;

    public Car(final String name) {
        validName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    public void movePosition(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_MOVE;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validName(String name) {
        validLength(name);
        validNullName(name);
        validSpaceName(name);
    }

    private void validLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NOT_ALLOW_MAXIMUM_LENGTH_ERROR);
        }
    }

    private void validNullName(String name) {
        if (name.length() <= MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NOT_ALLOW_MINIMUM_LENGTH_ERROR);
        }
    }

    private void validSpaceName(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(NOT_ALLOW_SPACE_ERROR);
        }
    }
}
