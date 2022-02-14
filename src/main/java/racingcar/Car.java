package racingcar;

public class Car {

    public static final int START_POSITION = 0;
    public static final int MINIMUM_NAME_LENGTH = 0;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String SPACE = " ";

    public static final String NOT_ALLOW_MAXIMUM_LENGTH_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 5자 이하만 가능합니다.)";
    public static final String NOT_ALLOW_MINIMUM_LENGTH_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 1자 이상만 가능합니다.)";
    public static final String NOT_ALLOW_SPACE_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름에 공백 입력은 불가능합니다.)";

    private String name;
    private int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = START_POSITION;
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

    public void movePosition(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
