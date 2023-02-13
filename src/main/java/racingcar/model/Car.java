package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVING_NUM = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR = "[ERROR] 분리한 자동차 이름이 5글자를 초과했습니다.";
    private static final String SPLIT_CAR_NAME_BLANK_ERROR = "[ERROR] 분리한 자동차 이름은 빈 값일 수 없습니다.";

    private final String name;
    private int position;

    public Car(final String name, int startPosition) {
        validateName(name);
        this.name = name;
        this.position = startPosition;
    }

    private void validateName(String name) {
        if (isWrongNameLength(name)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
        if (isBlankName(name)) {
            throw new IllegalArgumentException(SPLIT_CAR_NAME_BLANK_ERROR);
        }
    }

    private boolean isWrongNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }

    private boolean isBlankName(String carName) {
        return carName.equals("");
    }

    public boolean canMoving(final int power) {
        return power >= MIN_MOVING_NUM;
    }

    public void move(boolean isMoving) {
        if (isMoving) {
            this.position++;
        }
    }

    public boolean isSamePositionCar(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car anotherCar) {
        return this.position - anotherCar.position;
    }
}
