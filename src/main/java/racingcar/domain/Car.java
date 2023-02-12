package racingcar.domain;

import racingcar.constant.ErrorConstant;
import racingcar.dto.CarStatus;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;
    private final Position currentPosition;

    public Car(String name, int startPoint) {
        validateName(name);
        this.name = name;
        this.currentPosition = new Position(startPoint);
    }

    public String getName() {
        return name;
    }

    public CarStatus move(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        if (isMovable(randomNumber)) {
            currentPosition.move();
        }
        return new CarStatus(name, currentPosition);
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name, currentPosition);
    }

    public int compareTo(Car other) {
        return this.currentPosition.getPosition() - other.currentPosition.getPosition();
    }

    public boolean isSamePosition(Car target) {
        return currentPosition.equals(target.currentPosition);
    }

    public void validateName(String input) {
        if (input.length() > 5 || input.length() <1) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    private void validateName(String input) {
        String name = removeBlank(input);
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private String removeBlank(String input) {
        return input.trim();
    }
}
