package racingcar.domain;

import racingcar.dto.CarStatus;

import static racingcar.constant.GameConstant.MINIMUM_NUMBER_TO_MOVE;

public class Car {
    private final String name;
    private final Position currentPosition;

    public Car(String name, int startPoint) {
        this.name = name;
        this.currentPosition = new Position(startPoint);
    }

    public void move(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();

        if (isMovable(randomNumber)) {
            currentPosition.move();
        }
    }

    public CarStatus checkCurrentStatus() {
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

    public void validateName(String input) {
        if (input.length() > 5 || input.length() <1) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    public String getName() {
        return name;
    }
}
