package racingcar.domain;

import racingcar.condition.MovingCarCondition;

import java.util.List;

public class Car {
    private final static String MESSAGE_LENGTH_OF_CAR_NAME = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private final static String MESSAGE_NO_SPACE = "이름에 공백을 포함할 수 없습니다.";
    private final static int MAX_LENGTH_OF_NAME = 5;
    private String name;
    private int distance;

    public Car(String name) {
        validateLengthOfCarName(name);
        validateNoSpace(name);
        this.name = name;
        this.distance = 0;
    }

    public void moveCar(MovingCarCondition condition) {
        if (condition.isSatisfied()) {
            distance++;
        }
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 음수가 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateLengthOfCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(MESSAGE_LENGTH_OF_CAR_NAME);
        }
    }

    private void validateNoSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(MESSAGE_NO_SPACE);
        }
    }
}
