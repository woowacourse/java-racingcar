package racingcar.domain;

public class Car {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String ERROR = "[ERROR] ";
    private static final String CAR_NAME_LENGTH_ERROR = ERROR + "자동차 이름은 " +
            MINIMUM_CAR_NAME_LENGTH + " 이상 " +
            MAXIMUM_CAR_NAME_LENGTH + " 이하로 입력해 주세요.";
    private static final int MOVEMENT_CRITERION = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if ((name.length() < MINIMUM_CAR_NAME_LENGTH) || (name.length() > MAXIMUM_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public void move(Movable movable) {
        if (movable.extractRandom() >= MOVEMENT_CRITERION) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
